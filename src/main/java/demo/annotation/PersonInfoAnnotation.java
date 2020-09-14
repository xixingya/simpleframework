package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/26 9:14
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonInfoAnnotation {
    //名字
    public String name();

    //age
    public int age() default 10;

    //sex
    public String sex() default "男";

    //language
    public String[] language();


}
