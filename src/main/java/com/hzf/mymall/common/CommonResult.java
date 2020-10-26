package com.hzf.mymall.common;

/**
 * @author：010980380
 * @date:2020-10-26
 * @verison:1.0.0
 * @description：通用返回对象
 */

public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult(){}

    protected CommonResult(long code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * 成功返回结果
     * @param data 获取的数据
     * @return CommonResult<T>
     * @author huangzifan
     * @since 2020-10-26 15:43
     */
    public static <T> CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * 成功返回结果
     * @param data 获取的数据
     * @param message 提示信息
     * @return CommonResult<T>
     * @author huangzifan
     * @since 2020-10-26 15:43
     */
    public static <T> CommonResult<T> success(T data,String message){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码对象
     * @return CommonResult<T>
     * @author huangzifan
     * @since 2020-10-26 15:49
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode){
        return new CommonResult<T>(errorCode.getCode(),errorCode.getMessage(),null);
    }
    /**
     * 失败返回结果
     * @param errorCode 错误码对象
     * @param message 提示信息
     * @return CommonResult<T>
     * @author huangzifan
     * @since 2020-10-26 15:50
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode,String message){
        return new CommonResult<T>(errorCode.getCode(),message,null);
    }
    /**
     * 失败返回结果
     * @param message 提示信息
     * @return CommonResult<T>
     * @author huangzifan
     * @since 2020-10-26 15:50
     */
    public static <T> CommonResult<T> failed(String message){
        return new CommonResult<T>(ResultCode.FAILED.getCode(),message,null);
    }
    /**
     * 失败返回结果
     * @return CommonResult<T>
     * @author huangzifan
     * @since 2020-10-26 15:51
     */
    public static <T> CommonResult<T> failed(){
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @return CommonResult<T>
     * @author huangzifan
     * @since 2020-10-26 16:04
     */
    public static <T> CommonResult<T> vaildateFailed(){
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     * @return CommonResult<T>
     * @author huangzifan
     * @since 2020-10-26 16:05
     */
    public static <T> CommonResult<T> validateFailed(String message){
        return failed(ResultCode.VALIDATE_FAILED,message);
    }

    /**
     * 未登录返回结果
     * @param data  
     * @return CommonResult<T>
     * @author huangzifan
     * @since 2020-10-26 16:04
     */
    public static <T> CommonResult<T> unauthorized(T data){
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage(),data);
    }
    /**
     * 未授权返回结果
     * @param data
     * @return CommonResult<T>
     * @author huangzifan
     * @since 2020-10-26 16:04
     */
    public static <T> CommonResult<T> forbidden(T data){
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMessage(),data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
