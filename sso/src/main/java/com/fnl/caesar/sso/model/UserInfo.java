package com.fnl.caesar.sso.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author dengcheng
 * @Date 2018/11/25
 **/
@Entity
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue
    private Integer uid;
    /**
     * 帐号
     */
    @Column(unique =true)
    private String userName;
    /**
     * 名称（昵称或者真实姓名，不同系统不同定义）
     */
    private String name;
    /**
     *  密码;
     */
    private String password;
    /**
     * 加密密码的盐
     */
    private String salt;
    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    private byte state;
    /**
     * 立即从数据库中进行加载数据;
     * 一个用户具有多个角色
     */
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.userName+this.salt;
    }
}
