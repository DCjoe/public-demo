package com.fnl.caesar.wechat;

import com.fnl.caesar.wechat.commons.utils.WechatUtil;
import com.fnl.caesar.wechat.model.wechat.menu.Button;
import com.fnl.caesar.wechat.model.wechat.menu.ClickButton;
import com.fnl.caesar.wechat.model.wechat.menu.Menu;
import com.fnl.caesar.wechat.model.wechat.menu.ViewButton;
import com.fnl.caesar.wechat.service.IWechatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatApplicationTests {
    @Resource
    IWechatService wechatService;

    @Test
    public void contextLoads() {
        String accessToken =  wechatService.getAccessToken();
        if (null != accessToken) {
            // 调用接口创建菜单
            int result = WechatUtil.createMenu(getMenu(), accessToken);
            // 判断菜单创建结果
            if (0 == result){
                System.out.println("菜单创建成功！");
            }else{
                System.out.println("菜单创建失败，错误码：" + result);
            }
        }
    }

    /**
     * 组装菜单数据
     *
     * @return
     */
    private static Menu getMenu(){

        ClickButton clickButton01 = new ClickButton();
        clickButton01.setType("pic_weixin");
        clickButton01.setName("微信相册发图");
        clickButton01.setKey("rselfmenu_1_2");
        clickButton01.setSub_button(new Button[]{});

        ViewButton viewButton01 = new ViewButton();
        viewButton01.setUrl("https://d48d7b3a.ngrok.io/");
        viewButton01.setType("view");
        viewButton01.setName("网页");
        viewButton01.setSub_button(new Button[]{});


        Button button01 = new Button();
        button01.setName("学习");
        button01.setSub_button(new Button[]{clickButton01,viewButton01});

        Button button02 = new Button();
        button02.setName("微信接口");
        button02.setSub_button(new Button[]{});


        Menu menu = new Menu();
        menu.setButton(new Button[]{button01,button02});
        return menu;
    }

}
