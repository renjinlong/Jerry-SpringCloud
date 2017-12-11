package com.jerry.security.auth.controller;

import com.jerry.security.auth.service.ClientService;
import com.jerry.security.common.msg.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientRest {

    @Autowired
    private ClientService clientService;

    /**
     * 客服端获取密钥
     *
     * @param clientId
     * @param secret
     * @return
     */
    @RequestMapping(value = "token", method = RequestMethod.POST)
    public ObjectRestResponse getAccessToken(String clientId, String secret) throws Exception {
        return new ObjectRestResponse<String>().data(clientService.apply(clientId, secret));
    }

    @RequestMapping(value = "myClient")
    public List<String> getAllowedClient(String clientId, String secret) {
        List<String> allowedClient = clientService.getAllowedClient(clientId, secret);
        return allowedClient;
    }

}
