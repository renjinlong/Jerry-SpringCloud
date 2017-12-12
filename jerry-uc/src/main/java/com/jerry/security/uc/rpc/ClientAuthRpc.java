package com.jerry.security.uc.rpc;

import com.jerry.security.common.msg.ObjectRestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author renjinlong
 * @Title:
 * @Package com.jerry.security.uc.rpc
 * @Description: TODO
 * @date 2017/12/11 下午2:41
 */
@FeignClient("jerry-auth-service")
public interface ClientAuthRpc {

    @RequestMapping(value = "/client/myClient")
    public ObjectRestResponse<List<String>> getAllowedClient(@RequestParam("serviceId") String serviceId,@RequestParam("secret") String secret);
}
