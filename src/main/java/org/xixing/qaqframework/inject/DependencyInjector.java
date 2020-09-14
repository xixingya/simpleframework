package org.xixing.qaqframework.inject;

import lombok.extern.slf4j.Slf4j;
import org.xixing.qaqframework.core.BeanContainer;
import org.xixing.qaqframework.inject.annotation.Autowired;
import org.xixing.qaqframework.util.ClassUtil;
import org.xixing.qaqframework.util.ValidationUtil;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/27 15:31
 */
@Slf4j
public class DependencyInjector {
    private BeanContainer beanContainer;

    public DependencyInjector() {
        beanContainer = BeanContainer.getInstance();
    }

    public void doIoc() {
        //1.遍历Bean容器中所有的Class对象
        if (ValidationUtil.isEmpty(beanContainer.getClasses())) {
            log.warn("empty classset in beanContainer");
            return;
        }

        //2.遍历Class对象的所有成员变量
        for (Class<?> clazz : beanContainer.getClasses()) {
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)) {
                continue;
            }

            for (Field field : fields) {
                //3.找出被Autowired标记的成员变量
                if (field.isAnnotationPresent(Autowired.class)) {
                    //4.获取这些成员变量的类型
                    Class<?> fieldType = field.getType();
                    //获取value的值
                    Autowired autowired = field.getAnnotation(Autowired.class);
                    String value = autowired.value();

                    //5.获取这些成员变量的类型在容器里对应的类
                    Object fieldBean = getFieldInstance(fieldType, value);

                    //6.通过反射将对应的成员变量实例注入到成员变量所在的类中
                    Object containerBean = beanContainer.getBean(clazz);
                    ClassUtil.setField(field, containerBean, fieldBean, true);
                }
            }
        }


    }

    /**
     * 获取Field对应的实例
     *
     * @param fieldType      对应的类或者接口的类型，
     *                       去bean里面找他的实现类
     * @param autowiredValue 实现类的名字，预防有多个实现类，
     *                       如果是""代表只有一个实现类
     * @return
     */
    private Object getFieldInstance(Class fieldType, String autowiredValue) {
        Object bean = beanContainer.getBean(fieldType);
        //如果传入的是接口，找不到bean，那么尝试找其子类
        if (bean == null) {
            Object aClass = getImplementClass(fieldType, autowiredValue);
            return aClass;
        } else {
            return bean;
        }

    }

    private Object getImplementClass(Class fieldType, String autowiredValue) {
        Set<Class<?>> classBySuper = beanContainer.getClassBySuper(fieldType);
        if (ValidationUtil.isEmpty(classBySuper)) {
            log.error("找不到实现类:fieldType=" + fieldType);
            throw new RuntimeException();
        }
        //没有传value，查是否只有一个实现类，如果是，直接返回
        if (ValidationUtil.isEmpty(autowiredValue)) {
            if (classBySuper.size() > 1) {
                log.error("实现类多于一个，并且未指定是实现类，无法注入。。");
                throw new RuntimeException("实现类多于一个，并且未指定是实现类，无法注入。。field="+fieldType);
            }
            //只有一个的情况，直接返回
            return beanContainer.getBean(classBySuper.iterator().next());

        }

        for (Class<?> aClass : classBySuper) {
            if (aClass.getSimpleName().equals(autowiredValue)) {
                return beanContainer.getBean(aClass);
            }
        }

        log.error("没有找到实现类，注入失败");
        throw new RuntimeException();

    }
}
