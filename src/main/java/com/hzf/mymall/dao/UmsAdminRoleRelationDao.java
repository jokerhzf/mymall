package com.hzf.mymall.dao;

import com.hzf.mymall.model.UmsAdminRoleRelation;
import com.hzf.mymall.model.UmsPermission;
import com.hzf.mymall.model.UmsResource;
import com.hzf.mymall.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author：010980380
 * @date:2020-10-28
 * @verison:1.0.0
 * @description：自定义后台用户与角色管理Dao
 */

public interface UmsAdminRoleRelationDao {
    /**
     * 批量插入用户角色关系
     * @param adminRoleRelationList
     * @return
     */
    int insertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);

    /**
     * 获取用于所有角色
     * @param adminId
     * @return
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有角色权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getRolePermissionList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有权限(包括+-权限)
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有可访问资源
     * @param adminId
     * @return
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 获取资源相关用户ID列表
     * @param resourceId
     * @return
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}
