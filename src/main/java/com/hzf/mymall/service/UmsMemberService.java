package com.hzf.mymall.service;

import com.hzf.mymall.common.CommonResult;

/**
 * @author：010980380
 * @date:2020-10-27
 * @verison:1.0.0
 * @description：UmsMember Service类
 */

public interface UmsMemberService {

    /**
     * 通过手机获取验证码，
     * 生成验证码时，将自定义的Redis键值加上手机号
     * 生成一个Redis的密钥，以验证码为值存入到Redis中
     * ，并设置时间为自己配置的时间（此处为120s）
     * @param telephone 手机号
     * @return CommonResult
     * @author huangzifan
     * @since 2020-10-27 14:09
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 通过手机和验证码验证
     * 验证码时根据手机号码来获取Redis内部存储的验证码
     * ，并与初始化的验证码进行比对。
     * @param telephone 手机号
     * @param authCode 验证码
     * @return CommonResult
     * @author huangzifan
     * @since 2020-10-27 14:10
     */
    CommonResult verifyAuthCode(String telephone,String authCode);
}
