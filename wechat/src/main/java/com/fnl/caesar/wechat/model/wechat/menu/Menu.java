package com.fnl.caesar.wechat.model.wechat.menu;

import lombok.Data;

import java.io.Serializable;

/**
 *  整个菜单对象的封装
 * @Author dengcheng
 * @Date 2018/11/18
 **/
@Data
public class Menu implements Serializable {
    private Button[] button;
}
