package org.xixing.qaqframework.mvc.render;

import org.xixing.qaqframework.mvc.RequestProcessorChain;

/**
 * @author liuzhifei
 * @version 1.0
 * @date 2021/11/10 7:10 PM
 */
public interface ResultRender {
    /**
     * 执行渲染
     * @param requestProcessorChain
     * @throws Exception
     */
    void render(RequestProcessorChain requestProcessorChain) throws Exception;
}
