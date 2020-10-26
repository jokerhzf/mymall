package com.hzf.mymall.common;

/**
 * @author：010980380
 * @date:2020-10-26
 * @verison:1.0.0
 * @description：自定义错误码接口
 */

public interface IErrorCode {
    long getCode();

    String getMessage();
}
