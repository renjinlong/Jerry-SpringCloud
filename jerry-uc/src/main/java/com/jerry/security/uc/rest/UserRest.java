package com.jerry.security.uc.rest;

import com.jerry.security.common.rest.BaseController;
import com.jerry.security.uc.biz.TUserBiz;
import com.jerry.security.uc.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ace on 2017/9/3.
 */
@RestController
@RequestMapping("user")
public class UserRest extends BaseController<TUserBiz, TUser> {
    @Value("${language.en:Local Hello World}")
    private String language;

    @RequestMapping("test")
    @ResponseBody
    public String test() throws InterruptedException {
//        Thread.sleep(7000);
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

}
