package demo.annotation;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/26 9:21
 */
@CourseInfoAnnotation(courseName = "剑指offer",courseTag = "qaq",courseProfile = "qaq")
public class ImoocCourse {

    @PersonInfoAnnotation(name = "xixingya",language = {"java","python"})
    public String author;


    @CourseInfoAnnotation(courseName = "剑指offer",courseTag = "qaq",courseProfile = "qaq")
    public void getCourseInfo(){

    }
}
