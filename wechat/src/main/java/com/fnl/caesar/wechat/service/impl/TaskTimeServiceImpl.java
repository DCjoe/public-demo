package com.fnl.caesar.wechat.service.impl;

import com.fnl.caesar.wechat.commons.utils.WechatUtil;
import com.fnl.caesar.wechat.model.wechat.AccessToken;
import com.fnl.caesar.wechat.service.TaskTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName TaskTimeServiceImpl
 * @Description TODO
 * @Author dengcheng
 * @Date 2018/11/16 0016 下午 16:09
 **/
@Component
public class TaskTimeServiceImpl implements TaskTimeService {

    @Autowired
    RedisTemplate redisTemplate;

    @Scheduled(fixedRate = 1000*7200)
    @Override
    public void getAccessToken() {
        AccessToken accessToken = WechatUtil.getAccessToken();
        redisTemplate.opsForValue().set("AccessToken",accessToken.getAccess_token(),accessToken.getExpires_in(), TimeUnit.SECONDS);
        System.out.println(accessToken.getAccess_token());
    }
}
