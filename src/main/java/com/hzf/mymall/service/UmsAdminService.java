package com.hzf.mymall.service;

import com.hzf.mymall.model.UmsAdmin;
import com.hzf.mymall.model.UmsPermission;

import java.util.List;

/**
 * @author：010980380
 * @date:2020-10-28
 * @verison:1.0.0
 * @description：后台管理员 Service类
 */

public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     * @param username  
     * @return com.hzf.mymall.model.UmsAdmin
     * @author huangzifan
     * @since 2020-10-28 14:37
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     * @param umsAdminParam  
     * @return com.hzf.mymall.model.UmsAdmin
     * @author huangzifan
     * @since 2020-10-28 14:37
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return java.lang.String
     * @author huangzifan
     * @since 2020-10-28 14:37
     */
    String login(String username,String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     * @param adminId
     * @return java.util.List<com.hzf.mymall.model.UmsPermission>
     * @author huangzifan
     * @since 2020-10-28 14:37
     */
    List<UmsPermission> getPermissionList(Long adminId);

}
