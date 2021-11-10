package org.xixing.qaqframework.mvc;

import lombok.Data;
import org.xixing.qaqframework.mvc.processor.RequestProcessor;
import org.xixing.qaqframework.mvc.render.ResultRender;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

/**
 * @author liuzhifei
 * @version 1.0
 * @date 2021/11/9 7:40 PM
 */
@Data
public class RequestProcessorChain {

    private Iterator<RequestProcessor> requestProcessorIterator;

    private HttpServletRequest request;

    private HttpServletResponse response;

    private String requestMethod;

    private String requestPath;

    private Integer responseCode;

    private ResultRender resultRender;
}
