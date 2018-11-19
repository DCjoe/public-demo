package com.fnl.caesar.wechat.model.wechat.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * 回复消息的基类
 * @Author dengcheng
 * @Date 2018/11/17
 **/
@Data
public class BaseMessage implements Serializable {
    @XStreamAlias("ToUserName")
    @XStreamCDATA
    protected String ToUserName;
    @XStreamAlias("FromUserName")
    @XStreamCDATA
    protected String FromUserName;
    @XStreamAlias("CreateTime")
    protected long CreateTime;
    @XStreamAlias("MsgType")
    @XStreamCDATA
    protected String MsgType;
}
