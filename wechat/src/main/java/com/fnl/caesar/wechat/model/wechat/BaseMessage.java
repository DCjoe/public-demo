package com.fnl.caesar.wechat.model.wechat;

import lombok.Data;

import java.io.Serializable;

/**
 * 回复消息的基类
 * @Author dengcheng
 * @Date 2018/11/17
 **/
@Data
public class BaseMessage implements Serializable {
    protected String ToUserName;
    protected String FromUserName;
    protected long CreateTime;
    protected String MsgType;
}
