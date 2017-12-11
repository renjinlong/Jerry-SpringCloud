package com.jerry.security.gate;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author renjinlong
 * @Title:
 * @Package com.jerry.security.gate
 * @Description: TODO
 * @date 2017/12/1 下午4:06
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = GateBootstrap.class)
@WebMvcTest
public class BaseUnitTest {
}
