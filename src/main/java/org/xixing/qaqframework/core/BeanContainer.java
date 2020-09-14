package org.xixing.qaqframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.xixing.qaqframework.core.annotation.Component;
import org.xixing.qaqframework.core.annotation.Controller;
import org.xixing.qaqframework.core.annotation.Repository;
import org.xixing.qaqframework.core.annotation.Service;
import org.xixing.qaqframework.util.ClassUtil;
import org.xixing.qaqframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/27 8:32
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {

    /**
     * 存放所有被标记的目标对象
     */
    private static final Map<Class<?>,Object> BEAN_MAP=new ConcurrentHashMap();


    /**
     * 判断是否被加载过
     */
    private  boolean loaded=false;

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    /**
     * 加载bean的注解列表
     *
     */
    private static final List<Class<?extends Annotation>> BEAN_ANNOTATION=
            Arrays.asList(Component.class, Controller.class, Repository.class, Service.class);


    /**
     * 获取实例
     * @return
     */
    public static BeanContainer getInstance(){
        return ContainerHolder.HOLDER.instance;
    }


    private enum ContainerHolder{
        //单例模式下的实例
        HOLDER;
        private BeanContainer instance;
        private ContainerHolder(){
            instance=new BeanContainer();
        }
    }


    /**
     * 扫描加载所有的Bean
     * @param packageName
     */
    public synchronized void loadBeans(String packageName){


        if(isLoaded()){
            log.warn("bean has been loaded");
            return;
        }

        //获取目标包下面的所有对象
        Set<Class<?>> classSet= ClassUtil.extractPackageClass(packageName);
        if(classSet==null||classSet.isEmpty()){
            log.warn("scan the package can not get the class,package name="+packageName);
            return;
        }
        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> aClass : BEAN_ANNOTATION) {
                if(clazz.isAnnotationPresent(aClass)){
                    Object instance = ClassUtil.getInstance(clazz, true);
                    BEAN_MAP.put(clazz,instance);
                }
            }
        }

        loaded=true;

    }

    /**
     * 获取bean个数
     * @return
     */
    public static int size(){
        return BEAN_MAP.size();
    }

    /**
     * 添加一个bean
     * @param clazz
     * @param bean
     * @return
     */
    public Object addBean(Class<?> clazz,Object bean){
        return BEAN_MAP.put(clazz,bean);
    }


    /**
     * 删除bean
     * @param clazz
     * @return
     */
    public Object removeBean(Class<?> clazz){
        return BEAN_MAP.remove(clazz);
    }

    /**
     * 获取bean
     * @param clazz
     * @return
     */
    public Object getBean(Class<?> clazz){
        return BEAN_MAP.get(clazz);
    }

    /**
     * 获取所有的class
     * @return
     */
    public Set<Class<?>> getClasses(){
        return BEAN_MAP.keySet();
    }

    /**
     * 获取所有的beans
     * @return
     */
    public Set<Object> getBeans(){
        return new HashSet<>(BEAN_MAP.values());
    }


    /**
     * 根据注解筛选 class
     * @param annotation
     * @return
     */
    public Set<Class<?>> getClassByAnnotation(Class<? extends Annotation> annotation){
        Set<Class<?>> keySet=getClasses();
        if(ValidationUtil.isEmpty(keySet)){
            log.warn("can not found the class by Annotation:"+annotation);
            return null;
        }
        Set<Class<?>> byAnnotationSet=new HashSet<>();
        for (Class<?> aClass : keySet) {
            if(aClass.isAnnotationPresent(annotation)){
                byAnnotationSet.add(aClass);
            }

        }
        return byAnnotationSet.size()>0?byAnnotationSet:null;
    }


    public Set<Class<?>> getClassBySuper(Class<?> interfaceOrClass){
        Set<Class<?>> keySet=getClasses();
        if(ValidationUtil.isEmpty(keySet)){
            log.warn("can not found the class by Annotation:"+interfaceOrClass);
            return null;
        }

        //判断是否是传入接口或者class的子类
        Set<Class<?>> byAnnotationSet=new HashSet<>();
        for (Class<?> aClass : keySet) {
            if(interfaceOrClass.isAssignableFrom(aClass)&&!interfaceOrClass.equals(aClass)){
                byAnnotationSet.add(aClass);
            }

        }
        return byAnnotationSet.size()>0?byAnnotationSet:null;
    }







}
