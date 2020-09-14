package site.xixing.demo.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/18 10:36
 */
public class ConstructCollector {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("site.xixing.demo.reflect.ReflectTarget");


        //获取全部公有的构造方法
        System.out.println("获取全部公有的构造方法");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        //获取全部构造方法
        System.out.println("获取全部的构造方法");
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        //获取单个公有方法
        System.out.println("获取单个公有构造方法");
        Constructor<?> constructor = clazz.getConstructor(char.class);
        System.out.println(constructor);

        //获取单个私有方法
        System.out.println("获取单个私有构造方法");
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(int.class);
        System.out.println(declaredConstructor);

        System.out.println("通过反射私有构造方法创建实例");
        declaredConstructor.setAccessible(true);
        ReflectTarget reflectTarget=(ReflectTarget) declaredConstructor.newInstance(1);
        reflectTarget.sayHello();


    }
}
