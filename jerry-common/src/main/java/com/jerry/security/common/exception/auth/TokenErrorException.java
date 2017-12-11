package com.jerry.security.common.exception.auth;

import com.jerry.security.common.constants.CommonConstants;
import com.jerry.security.common.exception.BaseException;

/**
 * @author renjinlong
 * @Title:
 * @Package com.jerry.security.common.exception.auth
 * @Description: TODO
 * @date 2017/11/30 上午10:19
 */
public class TokenErrorException extends BaseException {
    public TokenErrorException(String message, int status) {
        super(message, CommonConstants.EX_TOKEN_ERROR_CODE);
    }
}
