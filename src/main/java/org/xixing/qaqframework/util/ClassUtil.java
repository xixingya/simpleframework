package org.xixing.qaqframework.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/26 15:06
 */
@Slf4j
public class ClassUtil {

    /**
     * 获取package下面的所有的类
     *
     * @param packageName
     * @return
     */
    public static Set<Class<?>> extractPackageClass(String packageName){

        String FILE_PROTOCOL="file";

        //1.获取到classLoader
        ClassLoader classLoader=getClassLoader();
        //2.通过类加载器获取到加载的资源
        String replace = packageName.replace('.', '/');
        URL url=classLoader.getResource(replace);
        if(url==null){
            log.warn("输入的路径下找不到类");
            return null;
        }

        //依据不同的资源类型，采用不同的方法
        Set<Class<?>> classSet=null;

        if(url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)){
            classSet=new HashSet<>();
            File packageDirectory=new File(url.getPath());
            extraClassFile(classSet,packageDirectory,packageName);
        }



        return classSet;
    }


    /**
     *设置类的属性
     *
     * @param field 成员变量
     * @param target 类实例
     * @param value  成员变量的值
     * @param accessible  是否允许设置私有属性
     */
    public static void setField(Field field,Object target,Object value,boolean accessible){
        field.setAccessible(accessible);
        try {
            field.set(target,value);
        } catch (IllegalAccessException e) {
            log.error("field set error");
            e.printStackTrace();
        }
    }

    /**
     * 获取目标package的所有class文件
     * @param classSet 获取的class传入这里
     * @param sourceFile class所在目录
     * @param packageName
     */
    private static void extraClassFile(Set<Class<?>> classSet, File sourceFile, String packageName) {
        if(!sourceFile.isDirectory()){
            /*String absolutePath = sourceFile.getAbsolutePath();
            if(absolutePath.endsWith(".class")){
                addToClassSet(absolutePath);
            }*/
            return;
        }

        File[] files = sourceFile.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if(file.isDirectory()){
                    return true;
                }else {
                    String absolutePath = file.getAbsolutePath();
                    if(absolutePath.endsWith(".class")){
                        try {
                            addToClassSet(absolutePath);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return false;
            }
            /**
             * 加入到classSet中
             * @param absolutePath
             */
            private void addToClassSet(String absolutePath) throws ClassNotFoundException {
                //1.从absloutePath中获取全类名
                absolutePath=absolutePath.replace(File.separator,".");
                int i = absolutePath.indexOf(packageName);
                String className = absolutePath.substring(i, absolutePath.lastIndexOf("."));
                //2.获取class对象后导入到classSet
                Class clazz=Class.forName(className);
                classSet.add(clazz);


            }
        });

        if(files==null){
            return;
        }
        for (File file : files) {
            extraClassFile(classSet,file,packageName);
        }


    }

    /**
     *
     * @param clazz
     * @param flag 是否支持创建私有
     * @param <T>
     * @return
     */
    public static <T> T getInstance(Class clazz,Boolean flag){
        try {
            Constructor constructor=clazz.getDeclaredConstructor();
            constructor.setAccessible(flag);
            return (T)constructor.newInstance();

        } catch (Exception e) {
            log.error("new instance error",e);
            throw new RuntimeException();
        }
    }




    public static void main(String[] args) {
        extractPackageClass("site.xixing.entity");
    }

    /**
     * 获取当前的classLoader
     * @return
     */
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }
}
