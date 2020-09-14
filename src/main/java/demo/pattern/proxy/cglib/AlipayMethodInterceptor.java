package demo.pattern.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/9/14 10:19
 */
public class AlipayMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result=methodProxy.invokeSuper(o,args);
        after();
        return result;
    }


    private void before() {
        System.out.println("从银行取款！！！");
    }

    private void after() {
        System.out.println("转入对应的账户！！！");
    }
}
