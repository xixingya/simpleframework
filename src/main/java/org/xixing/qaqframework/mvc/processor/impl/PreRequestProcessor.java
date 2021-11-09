package org.xixing.qaqframework.mvc.processor.impl;

import org.xixing.qaqframework.mvc.RequestProcessorChain;
import org.xixing.qaqframework.mvc.processor.RequestProcessor;

/**
 * @author liuzhifei
 * @version 1.0
 * @date 2021/11/9 7:41 PM
 */
public class PreRequestProcessor implements RequestProcessor {
    @Override
    public boolean process(RequestProcessorChain requestProcessorChain) throws Exception {
        return false;
    }
}
