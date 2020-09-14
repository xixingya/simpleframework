package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToCPayment;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/9/12 16:07
 */
public class ToCPaymentImpl implements ToCPayment {
    @Override
    public void pay() {
        System.out.println("支付！！！");
    }
}
