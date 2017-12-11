package com.jerry.security.auth.mapper;

import com.jerry.security.auth.entity.GateClient;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * 
 * 
 * @author jerry
 * @email chinarenlong@foxmail.com
 * @date 2017-12-07 14:20:41
 */
public interface GateClientMapper extends Mapper<GateClient> {
    @Select(" SELECT\n" +
            "        client.CODE\n" +
            "      FROM\n" +
            "          gate_client client\n" +
            "      INNER JOIN gate_client_service gcs ON gcs.client_id = client.id\n" +
            "    WHERE\n" +
            "        gcs.service_id = #{serviceId}")
    @ResultType(String.class)
    List<String> selectAllowedClient(String serviceId);
	
}
