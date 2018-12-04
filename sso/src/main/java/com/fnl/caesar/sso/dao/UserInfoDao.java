package com.fnl.caesar.sso.dao;

import com.fnl.caesar.sso.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dengcheng
 */
public interface UserInfoDao extends JpaRepository<UserInfo,Long> {
}
