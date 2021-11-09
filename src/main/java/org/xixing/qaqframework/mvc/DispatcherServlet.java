package org.xixing.qaqframework.mvc;


import org.xixing.qaqframework.core.BeanContainer;
import org.xixing.qaqframework.inject.DependencyInjector;
import org.xixing.qaqframework.mvc.processor.RequestProcessor;
import org.xixing.qaqframework.mvc.processor.impl.ControllerRequestProcessor;
import org.xixing.qaqframework.mvc.processor.impl.JspRequestProcessor;
import org.xixing.qaqframework.mvc.processor.impl.PreRequestProcessor;
import org.xixing.qaqframework.mvc.processor.impl.StaticResourceRequestProcessor;
import site.xixing.controller.frontend.MainPageController;
import site.xixing.controller.superadmin.HeadLineOperationController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/*")
public class DispatcherServlet extends HttpServlet {

    List<RequestProcessor> PROCESSORS = new LinkedList<>();
    @Override
    public void init(){
        //1.初始化容器
        BeanContainer beanContainer =BeanContainer.getInstance();
        beanContainer.loadBeans("site.xixing");
        new DependencyInjector().doIoc();
        //2.初始化请求责任链
        PROCESSORS.add(new PreRequestProcessor());
        PROCESSORS.add(new JspRequestProcessor());
        PROCESSORS.add(new StaticResourceRequestProcessor());
        PROCESSORS.add(new ControllerRequestProcessor());

    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        //创建责任链对象
        new RequestProcessorChain();
        //通过责任链依次调用

        //对结果进行渲染
    }

}
