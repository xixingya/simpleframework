package demo.annotation;

import java.lang.annotation.Annotation;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/26 9:25
 */
public class AnnotationDemo {
    public static void main(String[] args) {
        ImoocCourse imoocCourse=new ImoocCourse();
        imoocCourse.getCourseInfo();
        System.out.println("finish");
        Annotation[] annotations = imoocCourse.getClass().getAnnotations();
    }
}
