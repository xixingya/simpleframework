package org.xixing.qaqframework.inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.xixing.qaqframework.core.BeanContainer;
import site.xixing.controller.frontend.MainPageController;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/27 16:18
 */
class DependencyInjectorTest {

    @DisplayName("依赖注入doIoc")
    @Test
    void doIoc() {

        BeanContainer beanContainer=BeanContainer.getInstance();
        beanContainer.loadBeans("site.xixing");
        Assertions.assertEquals(true,beanContainer.isLoaded());

        MainPageController bean =(MainPageController) beanContainer.getBean(MainPageController.class);

        Assertions.assertEquals(null,bean.getHeadLineShopCategoryCombineService());
        new DependencyInjector().doIoc();
        Assertions.assertNotNull(bean.getHeadLineShopCategoryCombineService());

    }
}