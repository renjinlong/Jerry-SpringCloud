package com.jerry.security.gate.util.user;

import com.jerry.security.auth.common.util.jwt.IJWTInfo;
import com.jerry.security.auth.common.util.jwt.JWTHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ace on 2017/9/10.
 */
@Component
public class JwtTokenUtil {

    @Value("${jwt.expire}")
    private int expire;
    @Value("${jwt.pri-key.path}")
    private String priKeyPath;
    @Value("${jwt.pub-key.path}")
    private String pubKeyPath;

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;

    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.generateToken(jwtInfo,priKeyPath,expire);
    }

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token,pubKeyPath);
    }

}
