package com.fnl.caesar.wechat.model.wechat.menu;

import lombok.Data;

import java.io.Serializable;

/**
 * 菜单项的基类
 * @Author dengcheng
 * @Date 2018/11/18
 **/
@Data
public class Button implements Serializable {
    private String name;
    private String type;
    private Button[] sub_button;
}
