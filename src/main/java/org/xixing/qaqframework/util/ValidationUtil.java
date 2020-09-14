package org.xixing.qaqframework.util;

import java.util.Collection;
import java.util.Map;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/27 9:19
 */
public class ValidationUtil {


    /**
     * Collection是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Collection obj){
        return obj==null||obj.isEmpty();
    }

    /**
     * String 是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(String obj){
        return obj==null||"".equals(obj);
    }

    /**
     * map是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Map<?,?> obj){
        return obj==null||obj.isEmpty();
    }

    public static boolean isEmpty(Object[] obj){
        return obj==null||obj.length==0;
    }
}
