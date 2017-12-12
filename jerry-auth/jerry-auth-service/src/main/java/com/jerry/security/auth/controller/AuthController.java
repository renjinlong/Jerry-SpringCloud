package com.jerry.security.auth.controller;

import com.jerry.security.auth.bean.UserInfo;
import com.jerry.security.auth.biz.UserBiz;
import com.jerry.security.auth.entity.User;
import com.jerry.security.auth.util.user.JwtTokenUtil;
import com.jerry.security.common.exception.UserInvalidException;
import com.jerry.security.common.msg.ObjectRestResponse;
import com.jerry.security.common.rest.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ace on 2017/9/3.
 */
@RestController
@RequestMapping("jwt")
public class AuthController extends BaseController<UserBiz, User> {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(path = "token", method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse userLogin(String username, String password) {
        User sendUser = new User();
        sendUser.setUsername(username);
        sendUser.setPassword(password);
        User user = baseBiz.selectOne(sendUser);

        if (user == null)
            throw new UserInvalidException("user null");

        String token;
        try {
            token = jwtTokenUtil.generateToken(new UserInfo(user.getId()+"",user.getUsername(),user.getName()));
        } catch (Exception e) {
            throw new UserInvalidException("token error");
        }
        return new ObjectRestResponse<String>().data(token);
    }

}
