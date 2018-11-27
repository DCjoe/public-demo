package com.fnl.caesar.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PageController
 * @Description TODO
 * @Author dengcheng
 * @Date 2018/11/27 0027 下午 13:52
 **/
@Controller
public class HomeController {

    @RequestMapping({"/index","/"})
    public String indexPage(){
        return "index";
    }


    @RequestMapping("/403")
    public String unauthorizedRole(){
        return "index";
    }

}
