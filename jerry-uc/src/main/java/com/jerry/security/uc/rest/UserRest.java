package com.jerry.security.uc.rest;

import com.jerry.security.common.context.BaseContextHandler;
import com.jerry.security.common.rest.BaseController;
import com.jerry.security.uc.biz.TUserBiz;
import com.jerry.security.uc.entity.TUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by ace on 2017/9/3.
 */
@RestController
@RequestMapping("user")
public class UserRest extends BaseController<TUserBiz, TUser> {
    @Value("${language.en:Local Hello World}")
    private String language;

    @Value("${jwt.pri-key.path}")
    private String priKeyPath;

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return language;
    }

    @RequestMapping(path = "addUser")
    @ResponseBody
    public String add(@RequestParam("uploaddata") String uploaddata) {
        TUser tUser = new TUser();
        tUser.setUserid(1);
        tUser.setAddress("这是一个地址");
        baseBiz.insert(tUser);
        return "success";
    }

    @RequestMapping("who")
    public String getCurrentUser() {
        return BaseContextHandler.getUsername();
    }

}
