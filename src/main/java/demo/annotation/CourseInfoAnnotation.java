package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/26 9:18
 */

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseInfoAnnotation {

    //课程名称
    public String courseName();

    //课程标签
    public String courseTag();

    //课程简介
    public String courseProfile();

    //课程序号
    public int courseIndex() default 303;

}
