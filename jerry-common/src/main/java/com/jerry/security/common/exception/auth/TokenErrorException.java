package com.jerry.security.common.exception.auth;


import com.jerry.security.common.constant.CommonConstants;
import com.jerry.security.common.exception.BaseException;

/**
 * Created by ace on 2017/9/8.
 */
public class TokenErrorException extends BaseException {
    public TokenErrorException(String message, int status) {
        super(message, CommonConstants.EX_TOKEN_ERROR_CODE);
    }
}
