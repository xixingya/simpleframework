package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToBPayment;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/9/14 10:03
 */
public class ToBPaymentImpl implements ToBPayment {

    @Override
    public void pay() {
        System.out.println("对公付款！！！");
    }
}
