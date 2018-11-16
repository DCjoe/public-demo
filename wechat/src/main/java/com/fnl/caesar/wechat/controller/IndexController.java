package com.fnl.caesar.wechat.controller;

import com.fnl.caesar.wechat.service.IWechatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author dengcheng
 * @Date 2018/11/16 0016 下午 14:08
 **/
@Controller
public class IndexController {

    @Resource
    IWechatService wechatService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/getAccessToken")
    @ResponseBody
    public Object getAccessToken(){
        return wechatService.getAccessToken();
    }
}
