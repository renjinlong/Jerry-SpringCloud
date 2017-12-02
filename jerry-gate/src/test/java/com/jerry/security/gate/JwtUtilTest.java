package com.jerry.security.gate;

import com.jerry.security.common.util.jwt.JWTHelper;
import com.jerry.security.common.util.jwt.JWTInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author renjinlong
 * @Title:
 * @Package com.jerry.security.gate
 * @Description: TODO
 * @date 2017/12/1 下午4:03
 */
public class JwtUtilTest extends BaseUnitTest {

    //    @Autowired
//    JwtUtil util;
    @Value("${jwt.pri-key.path}")
    String path;

    @Test
    public void testJwt() throws Exception {

    }

}
