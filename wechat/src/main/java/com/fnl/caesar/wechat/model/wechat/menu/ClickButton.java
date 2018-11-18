package com.fnl.caesar.wechat.model.wechat.menu;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author dengcheng
 * @Date 2018/11/18
 **/
@Data
public class ClickButton extends Button  implements Serializable {
    private String key;
}
