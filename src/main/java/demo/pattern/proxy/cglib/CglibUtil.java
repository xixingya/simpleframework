package demo.pattern.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/9/14 10:22
 */
public class CglibUtil {
    public static <T> T createCglibInstance(T targetObject, Callback callback){
        return (T) Enhancer.create(targetObject.getClass(),callback);
    }
}
