package com.fnl.caesar.sso.commons.utils;


import org.apache.commons.lang3.ArrayUtils;

/**
 * @ClassName ArrayUtil
 * @Description TODO
 * @Author dengcheng
 * @Date 2018/12/4 0004 下午 14:19
 **/
public class ArrayUtil {

    public static boolean isArray(Object object) {
        if (null == object) {
            throw new NullPointerException("Object check for isArray is null");
        }
        return object.getClass().isArray();
    }
}
