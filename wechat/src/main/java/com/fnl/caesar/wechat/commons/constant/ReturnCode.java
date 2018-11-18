package com.fnl.caesar.wechat.commons.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dengcheng on 2017/3/22.
 */
public enum ReturnCode {
    SUCCESS(0,"成功"),
    FAIL(1,"失败");

    private int code;
    private String desc;

    private ReturnCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static Map<Integer, ReturnCode> codes = new HashMap<Integer, ReturnCode>();

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public static ReturnCode getReturnCode(int code) {
        ReturnCode[] types = values();
        for (ReturnCode ct : types) {
            if (ct.getCode() == code) {
                return ct;
            }
        }
        return null;
    }


}

