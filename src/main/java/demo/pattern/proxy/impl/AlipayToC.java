package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToCPayment;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/9/12 16:08
 */
public class AlipayToC implements ToCPayment {

    ToCPayment toCPayment;

    public AlipayToC(ToCPayment toCPayment){
        this.toCPayment=toCPayment;
    }

    @Override
    public void pay() {
        before();
        toCPayment.pay();
        after();
    }

    private void before() {
        System.out.println("从银行取款！！！");
    }

    private void after() {
        System.out.println("转入对应的账户！！！");
    }
}
