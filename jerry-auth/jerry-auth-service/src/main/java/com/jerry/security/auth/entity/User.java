package com.jerry.security.auth.entity;

import com.jerry.security.auth.common.util.jwt.IJWTInfo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * @author jerry
 * @email chinarenlong@foxmail.com
 * @date 2017-12-07 17:35:04
 */
@Table(name = "base_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @Id
    private Integer id;

    //
    @Column(name = "username")
    private String username;

    //
    @Column(name = "password")
    private String password;

    //
    @Column(name = "name")
    private String name;

    //
    @Column(name = "birthday")
    private String birthday;

    //
    @Column(name = "address")
    private String address;

    //
    @Column(name = "mobile_phone")
    private String mobilePhone;

    //
    @Column(name = "tel_phone")
    private String telPhone;

    //
    @Column(name = "email")
    private String email;

    //
    @Column(name = "sex")
    private String sex;

    //
    @Column(name = "type")
    private String type;

    //
    @Column(name = "status")
    private String status;

    //
    @Column(name = "description")
    private String description;

    //
    @Column(name = "crt_time")
    private Date crtTime;

    //
    @Column(name = "crt_user")
    private String crtUser;

    //
    @Column(name = "crt_name")
    private String crtName;

    //
    @Column(name = "crt_host")
    private String crtHost;

    //
    @Column(name = "upd_time")
    private Date updTime;

    //
    @Column(name = "upd_user")
    private String updUser;

    //
    @Column(name = "upd_name")
    private String updName;

    //
    @Column(name = "upd_host")
    private String updHost;

    //
    @Column(name = "attr1")
    private String attr1;

    //
    @Column(name = "attr2")
    private String attr2;

    //
    @Column(name = "attr3")
    private String attr3;

    //
    @Column(name = "attr4")
    private String attr4;

    //
    @Column(name = "attr5")
    private String attr5;

    //
    @Column(name = "attr6")
    private String attr6;

    //
    @Column(name = "attr7")
    private String attr7;

    //
    @Column(name = "attr8")
    private String attr8;

    public Integer getId() {
        return id;
    }

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 设置：
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取：
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置：
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置：
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取：
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置：
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置：
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 获取：
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置：
     */
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    /**
     * 获取：
     */
    public String getTelPhone() {
        return telPhone;
    }

    /**
     * 设置：
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取：
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置：
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：
     */
    public String getType() {
        return type;
    }

    /**
     * 设置：
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取：
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置：
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取：
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置：
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * 获取：
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * 设置：
     */
    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    /**
     * 获取：
     */
    public String getCrtUser() {
        return crtUser;
    }

    /**
     * 设置：
     */
    public void setCrtName(String crtName) {
        this.crtName = crtName;
    }

    /**
     * 获取：
     */
    public String getCrtName() {
        return crtName;
    }

    /**
     * 设置：
     */
    public void setCrtHost(String crtHost) {
        this.crtHost = crtHost;
    }

    /**
     * 获取：
     */
    public String getCrtHost() {
        return crtHost;
    }

    /**
     * 设置：
     */
    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    /**
     * 获取：
     */
    public Date getUpdTime() {
        return updTime;
    }

    /**
     * 设置：
     */
    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    /**
     * 获取：
     */
    public String getUpdUser() {
        return updUser;
    }

    /**
     * 设置：
     */
    public void setUpdName(String updName) {
        this.updName = updName;
    }

    /**
     * 获取：
     */
    public String getUpdName() {
        return updName;
    }

    /**
     * 设置：
     */
    public void setUpdHost(String updHost) {
        this.updHost = updHost;
    }

    /**
     * 获取：
     */
    public String getUpdHost() {
        return updHost;
    }

    /**
     * 设置：
     */
    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    /**
     * 获取：
     */
    public String getAttr1() {
        return attr1;
    }

    /**
     * 设置：
     */
    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    /**
     * 获取：
     */
    public String getAttr2() {
        return attr2;
    }

    /**
     * 设置：
     */
    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    /**
     * 获取：
     */
    public String getAttr3() {
        return attr3;
    }

    /**
     * 设置：
     */
    public void setAttr4(String attr4) {
        this.attr4 = attr4;
    }

    /**
     * 获取：
     */
    public String getAttr4() {
        return attr4;
    }

    /**
     * 设置：
     */
    public void setAttr5(String attr5) {
        this.attr5 = attr5;
    }

    /**
     * 获取：
     */
    public String getAttr5() {
        return attr5;
    }

    /**
     * 设置：
     */
    public void setAttr6(String attr6) {
        this.attr6 = attr6;
    }

    /**
     * 获取：
     */
    public String getAttr6() {
        return attr6;
    }

    /**
     * 设置：
     */
    public void setAttr7(String attr7) {
        this.attr7 = attr7;
    }

    /**
     * 获取：
     */
    public String getAttr7() {
        return attr7;
    }

    /**
     * 设置：
     */
    public void setAttr8(String attr8) {
        this.attr8 = attr8;
    }

    /**
     * 获取：
     */
    public String getAttr8() {
        return attr8;
    }

}
