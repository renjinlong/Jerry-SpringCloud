package com.jerry.security.uc.biz;

import com.jerry.security.common.biz.BaseBiz;
import com.jerry.security.common.exception.BaseException;
import com.jerry.security.uc.entity.TUser;
import com.jerry.security.uc.mapper.TUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author renjinlong
 * @Title:
 * @Package com.jerry.security.uc.biz
 * @Description: TODO
 * @date 2017/11/29 下午2:56
 */
@Service
@Transactional
public class TUserBiz extends BaseBiz<TUserMapper, TUser> {

    @Override
    public TUser selectById(Object id) {
        throw new BaseException("this is error");
    }
}
