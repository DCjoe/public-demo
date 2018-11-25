package com.fnl.caesar.web.dao;

import com.fnl.caesar.web.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author dengcheng
 * @Date 2018/11/25
 **/
public interface UserInfoDao extends CrudRepository<UserInfo,Long> {
    /**
     * 通过userName查找用户信息
     * @param userName
     * @return
     */
    UserInfo findByUserName(String userName);
}
