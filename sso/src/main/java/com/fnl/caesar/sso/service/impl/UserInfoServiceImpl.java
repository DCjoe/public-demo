package com.fnl.caesar.sso.service.impl;

import com.fnl.caesar.sso.dao.UserInfoDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserInfoServiceImpl
 * @Description TODO
 * @Author dengcheng
 * @Date 2018/12/4 0004 下午 17:00
 **/
@Service("userInfoService")
public class UserInfoServiceImpl {
    @Resource
    UserInfoDao userInfoDao;
}
