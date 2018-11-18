package com.fnl.caesar.wechat.model.wechat;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName AccessToken
 * @Description TODO
 * @Author dengcheng
 * @Date 2018/11/16 0016 下午 15:16
 **/
@Data
public class AccessToken implements Serializable {
    private String access_token;
    private Long expires_in;
    private String errcode;
    private String errmsg;
}
