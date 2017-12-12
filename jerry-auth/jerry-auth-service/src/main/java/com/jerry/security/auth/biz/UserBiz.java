package com.jerry.security.auth.biz;

import com.jerry.security.auth.entity.User;
import com.jerry.security.auth.mapper.UserMapper;
import com.jerry.security.common.biz.BaseBiz;
import org.springframework.stereotype.Service;


/**
 * 
 *
 * @author jerry
 * @email chinarenlong@foxmail.com
 * @date 2017-12-07 17:35:04
 */
@Service
public class UserBiz extends BaseBiz<UserMapper,User> {
}