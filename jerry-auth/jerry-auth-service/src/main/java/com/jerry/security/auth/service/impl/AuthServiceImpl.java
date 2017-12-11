package com.jerry.security.auth.service.impl;

import com.jerry.security.auth.common.util.jwt.JWTInfo;
import com.jerry.security.auth.entity.UserInfo;
import com.jerry.security.auth.service.AuthService;
import com.jerry.security.auth.util.user.JwtTokenUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthServiceImpl implements AuthService {

    private JwtTokenUtil jwtTokenUtil;
//    private IUserService userService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

//    @Autowired
//    public AuthServiceImpl(JwtTokenUtil jwtTokenUtil,IUserService userService) {
//        this.jwtTokenUtil = jwtTokenUtil;
//        this.userService = userService;
//    }

    @Override
    public String login(String username, String password) throws Exception {
//        UserInfo info = userService.validate(username,password);
//        String token = "";
//        if (!StringUtils.isEmpty(info.getId())) {
//            token = jwtTokenUtil.generateToken(new JWTInfo(info.getUsername(), info.getId() + "", info.getName()));
//        }
        return "";
    }

    @Override
    public void validate(String token) throws Exception {
        jwtTokenUtil.getInfoFromToken(token);
    }

    @Override
    public Boolean invalid(String token) {
        // TODO: 2017/9/11 注销token
        return null;
    }

    @Override
    public String refresh(String oldToken) {
        // TODO: 2017/9/11 刷新token
        return null;
    }
}
