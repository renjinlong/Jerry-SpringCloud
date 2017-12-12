package com.jerry.security.auth.bean;

import com.jerry.security.auth.common.util.jwt.IJWTInfo;
import com.jerry.security.auth.entity.User;

/**
 * @author renjinlong
 * @Title:
 * @Package com.jerry.security.auth.bean
 * @Description: TODO
 * @date 2017/12/11 下午1:39
 */
public class UserInfo implements IJWTInfo {
    private String id;
    private String username;
    private String name;

    public UserInfo(String id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUniqueName() {
        return username;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
