package demo.pattern.proxy;

import demo.pattern.proxy.cglib.AlipayMethodInterceptor;
import demo.pattern.proxy.cglib.CglibUtil;
import demo.pattern.proxy.impl.AlipayToC;
import demo.pattern.proxy.impl.ToBPaymentImpl;
import demo.pattern.proxy.impl.ToCPaymentImpl;
import demo.pattern.proxy.jdkproxy.AlipayInvocationHandler;
import demo.pattern.proxy.jdkproxy.JdkDynamicProxyUtil;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/9/12 16:11
 */
public class ProxyDemo {
    public static void main(String[] args) {
        /*ToCPayment toCPayment=new ToCPaymentImpl();
        AlipayToC alipayToC=new AlipayToC(toCPayment);
        alipayToC.pay();*/


        /*ToCPayment toCPayment = new ToCPaymentImpl();
        AlipayInvocationHandler alipayInvocationHandler=new AlipayInvocationHandler(toCPayment);
        ToCPayment cPayment = JdkDynamicProxyUtil.newProxyInstance(toCPayment, alipayInvocationHandler);
        cPayment.pay();

        ToBPayment toBPayment = new ToBPaymentImpl();
        AlipayInvocationHandler handler=new AlipayInvocationHandler(toBPayment);
        ToBPayment bPayment = JdkDynamicProxyUtil.newProxyInstance(toBPayment, handler);
        bPayment.pay();*/

        CommonPayment commonPayment=new CommonPayment();
        /*AlipayInvocationHandler handler=new AlipayInvocationHandler(commonPayment);
        CommonPayment payment = JdkDynamicProxyUtil.newProxyInstance(commonPayment, handler);
        payment.pay();*/
        AlipayMethodInterceptor methodInterceptor=new AlipayMethodInterceptor();
        CommonPayment cglibInstance = CglibUtil.createCglibInstance(commonPayment, methodInterceptor);
        cglibInstance.pay();
        ToCPayment toCPayment=new ToCPaymentImpl();
        ToCPayment instance = CglibUtil.createCglibInstance(toCPayment, methodInterceptor);
        instance.pay();

    }

}
