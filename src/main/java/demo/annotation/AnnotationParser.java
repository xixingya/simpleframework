package demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/26 9:29
 */
public class AnnotationParser {
    //解析类的注解
    public static void parseTypeAnnotation() throws ClassNotFoundException {
        Class clazz=Class.forName("demo.annotation.ImoocCourse");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            CourseInfoAnnotation courseInfoAnnotation= (CourseInfoAnnotation) annotation;
            System.out.println(courseInfoAnnotation.courseName());
        }
    }

    public static void parseFieldAnnotation() throws ClassNotFoundException {
        Class clazz=Class.forName("demo.annotation.ImoocCourse");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            boolean present = field.isAnnotationPresent(PersonInfoAnnotation.class);
            if(present){
                PersonInfoAnnotation annotation = field.getAnnotation(PersonInfoAnnotation.class);
                System.out.println(annotation.name());
            }
        }
    }


    public static void parseMethodAnnotation() throws ClassNotFoundException {
        Class clazz=Class.forName("demo.annotation.ImoocCourse");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            boolean present = method.isAnnotationPresent(CourseInfoAnnotation.class);
            if(present){
                CourseInfoAnnotation annotation = method.getAnnotation(CourseInfoAnnotation.class);
                System.out.println(annotation.courseName());
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //parseTypeAnnotation();
        parseFieldAnnotation();
        //parseMethodAnnotation();
    }
}
