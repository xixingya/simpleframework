package org.xixing.qaqframework.core;

import org.junit.jupiter.api.*;
import org.xixing.qaqframework.core.annotation.Controller;
import site.xixing.controller.frontend.MainPageController;
import site.xixing.service.solo.HeadLineService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/27 9:39
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    public static void init(){
        beanContainer=BeanContainer.getInstance();
    }

    @Test
    void isLoaded() {

    }

    @Test
    void setLoaded() {
    }

    @Test
    void getInstance() {
    }

    @Order(1)
    @Test
    void loadBeans() {

        boolean loaded = beanContainer.isLoaded();
        if(!loaded){
            beanContainer.loadBeans("site.xixing");

        }
    }
    @Order(2)
    @Test
    void getBeans(){
        MainPageController bean = (MainPageController)beanContainer.getBean(MainPageController.class);
        System.out.println(bean);
    }

    @Order(3)
    @Test
    void getByAnnotation(){
        Set<Class<?>> annotationClass = beanContainer.getClassByAnnotation(Controller.class);
        Assertions.assertEquals(3,annotationClass.size());
    }


    @Order(4)
    @Test
    void getBySuper(){
        Set<Class<?>> classBySuper = beanContainer.getClassBySuper(HeadLineService.class);
        Assertions.assertEquals(1,classBySuper.size());
    }
}