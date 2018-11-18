package com.fnl.caesar.wechat.model.wechat.message;

import lombok.Data;

import java.io.Serializable;

/**
 * 消息内容实体
 * @Author dengcheng
 * @Date 2018/11/17
 **/
@Data
public class MessageText extends BaseMessage implements Serializable {
    // 文本消息内容
    private String Content;
    // 消息id，64位整型
    private String MsgId;

}
