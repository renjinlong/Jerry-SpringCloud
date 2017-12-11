package com.jerry.security.common.exception;

import com.jerry.security.common.constants.CommonConstants;

public class UserInvalidException extends BaseException {

    public UserInvalidException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }

}
