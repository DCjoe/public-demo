package com.fnl.caesar.sso.commons.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @ClassName ShiroUtil
 * @Description TODO
 * @Author dengcheng
 * @Date 2018/12/4 0004 下午 14:37
 **/
public class ShiroUtil {
    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static void logout() {
        getSubject().logout();
    }
}
