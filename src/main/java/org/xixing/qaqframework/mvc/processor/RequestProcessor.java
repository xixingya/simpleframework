package org.xixing.qaqframework.mvc.processor;

import org.xixing.qaqframework.mvc.RequestProcessorChain;

/**
 * @author liuzhifei
 * @version 1.0
 * @date 2021/11/9 7:38 PM
 */
public interface RequestProcessor {

    /**
     *
     * @param requestProcessorChain
     * @return
     * @throws Exception
     */
    boolean process(RequestProcessorChain requestProcessorChain) throws Exception;
}
