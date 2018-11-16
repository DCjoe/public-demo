package com.fnl.caesar.wechat.service.impl;

import com.fnl.caesar.wechat.commons.utils.WechatUtil;
import com.fnl.caesar.wechat.model.AccessToken;
import com.fnl.caesar.wechat.service.IWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName WechatServiceImpl
 * @Description TODO
 * @Author dengcheng
 * @Date 2018/11/16 0016 下午 13:13
 **/
@Service("wechatService")
public class WechatServiceImpl implements IWechatService {

    @Autowired
    RedisTemplate redisTemplate;

    @Cacheable(key = "#p0")
    @Override
    public String getAccessToken() {
        AccessToken accessToken = WechatUtil.getAccessToken();
        redisTemplate.opsForValue().set("AccessToken",accessToken.getAccess_token(),accessToken.getExpires_in(), TimeUnit.MINUTES);
        System.out.println(accessToken.getAccess_token());
        return accessToken.getAccess_token();
    }
}
