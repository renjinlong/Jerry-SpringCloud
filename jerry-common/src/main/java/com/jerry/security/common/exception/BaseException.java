package com.jerry.security.common.exception;

/**
 * @author renjinlong
 * @Title:
 * @Package com.jerry.security.common
 * @Description: TODO
 * @date 2017/11/30 上午10:06
 */
public class BaseException extends RuntimeException {

    private int status = 200;

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, int status) {
        super(message);
        this.status = status;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
