package com.jerry.security.auth.service.impl;

import com.jerry.security.auth.bean.ClientInfo;
import com.jerry.security.auth.entity.GateClient;
import com.jerry.security.auth.mapper.GateClientMapper;
import com.jerry.security.auth.service.ClientService;
import com.jerry.security.auth.util.client.ClientTokenUtil;
import com.jerry.security.common.exception.auth.ClientInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ace on 2017/9/10.
 */
@Service
public class DBClientService implements ClientService {
    @Autowired
    private GateClientMapper clientMapper;
    @Autowired
    private ClientTokenUtil clientTokenUtil;

    //    @Autowired
//    private DiscoveryClient discovery;
    private ApplicationContext context;

    @Autowired
    public DBClientService(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public String apply(String clientId, String secret) throws Exception {
        GateClient client = getClient(clientId, secret);
        return clientTokenUtil.generateToken(new ClientInfo(client.getCode(), client.getName(), client.getId().toString()));
    }

    private GateClient getClient(String clientId, String secret) {
        GateClient client = new GateClient();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        if (client == null || !client.getSecret().equals(secret)) {
            throw new ClientInvalidException("Client not found or Client secret is error!");
        }
        return client;
    }

    @Override
    public List<String> getAllowedClient(String clientId, String secret) {
        GateClient info = this.getClient(clientId, secret);
        List<String> clients = clientMapper.selectAllowedClient(info.getId() + "");
        if (clients == null) {
            new ArrayList<String>();
        }
        return clients;
    }

    private GateClient getClient(String clientId) {
        GateClient client = new GateClient();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        return client;
    }

//    @Override
//    @Scheduled(cron = "0 0/1 * * * ?")
//    public void registryClient() {
//        // 自动注册节点
//        discovery.getServices().forEach((name) ->{
//            GateClient client = new GateClient();
//            client.setName(name);
//            client.setCode(name);
//            GateClient dbClient = clientMapper.selectOne(client);
//            if(dbClient==null) {
//                client.setSecret(UUIDUtils.generateShortUuid());
//                clientMapper.insert(client);
//            }else{
//                // 主动推送
//                final List<String> clients = clientMapper.selectAllowedClient(dbClient.getId() + "");
//                final String myUniqueId = context.getId();
//                final AuthRemoteEvent event =
//                        new AuthRemoteEvent(this, myUniqueId, name, clients);
//                context.publishEvent(event);
//            }
//        });
//    }
}
