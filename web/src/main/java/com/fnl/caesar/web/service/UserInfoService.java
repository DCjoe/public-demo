package com.fnl.caesar.web.service;

import com.fnl.caesar.web.model.UserInfo;

public interface UserInfoService {
    UserInfo findByUserName(String userName);
}
