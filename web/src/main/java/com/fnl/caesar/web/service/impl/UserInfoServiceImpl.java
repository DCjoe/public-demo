package com.fnl.caesar.web.service.impl;

import com.fnl.caesar.web.dao.UserInfoDao;
import com.fnl.caesar.web.model.UserInfo;
import com.fnl.caesar.web.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author dengcheng
 * @Date 2018/11/25
 **/
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUserName(String userName) {
        return userInfoDao.findByUserName(userName);
    }
}
