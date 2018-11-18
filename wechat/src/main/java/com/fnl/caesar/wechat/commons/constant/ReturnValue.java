package com.fnl.caesar.wechat.commons.constant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.collect.ImmutableMap;

import java.io.Serializable;
import java.util.Map;

/**
 * @author dengcheng
 * @param <T>
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"returnCode", "message", "result"})
public class ReturnValue<T> implements Serializable {


    @JsonProperty("returnCode")
    private int returnCode;

    private String message;

    private T result;

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static <T> ReturnValue<T> buildSuccessResult(T obj) {
        ReturnValue<T> rt = new ReturnValue<>();
        rt.setReturnCode(0);
        rt.setResult(obj);
        rt.setMessage("");
        return rt;
    }

    public static ReturnValue buildErrorResult(int returnCode, String message) {
        ReturnValue rt = new ReturnValue();
        rt.setReturnCode(returnCode);
        rt.setMessage(message);
        return rt;
    }

    public static Map<String, Object> buildSuccessResult() {
        return ImmutableMap.of("returnCode", 0, "message", "");
    }

    public static Map buildErrorMessage(int returnCode, String message) {
        return ImmutableMap.of("returnCode", returnCode, "message", message);
    }

    @Override
    public String toString() {
        return "ReturnValue{" +
                "returnCode=" + returnCode +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
