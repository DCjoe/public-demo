package com.fnl.caesar.sso.commons.utils;



import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @ClassName CacheHashCode
 * @Description TODO
 * @Author dengcheng
 * @Date 2018/12/4 0004 下午 14:03
 **/
public class CacheHashCode {
    private Object[] params;
    private int code;

    private CacheHashCode(Object[] params) {
        this.params = params;
        this.code = Arrays.deepHashCode(params);
    }

    public static CacheHashCode of(Object object) {
        return new CacheHashCode(ArrayUtil.isArray(object) ? ArrayUtils.toArray(object) : new Object[]{object});
    }

    @Override
    public int hashCode() {
        return code;
    }

    public String hashString() {
        return code + "";
    }

    @Override
    public String toString() {
        return "CacheHashCode{" +
                "params=" + Arrays.toString(params) +
                ", code=" + code +
                '}';
    }
}
