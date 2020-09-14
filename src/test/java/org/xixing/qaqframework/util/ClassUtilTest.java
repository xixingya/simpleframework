package org.xixing.qaqframework.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/26 16:12
 */
class ClassUtilTest {

    @DisplayName("qaq")
    @Test
    public void extractPackageClass() {
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("site.xixing.entity");

        Assertions.assertEquals(classSet.size(),4);
    }

    @Test
    void main() {
    }

    @Test
    void getClassLoader() {
    }
}