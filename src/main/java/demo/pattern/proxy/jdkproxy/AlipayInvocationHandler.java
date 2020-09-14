package demo.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/9/14 9:50
 */
public class AlipayInvocationHandler implements InvocationHandler {

    private Object targetObject;

    public AlipayInvocationHandler(Object targetObject){
        this.targetObject=targetObject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(targetObject, args);
        after();
        return invoke;
    }

    private void before() {
        System.out.println("从银行取款！！！");
    }

    private void after() {
        System.out.println("转入对应的账户！！！");
    }

}
