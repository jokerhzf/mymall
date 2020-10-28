package com.hzf.mymall.dao;

import com.hzf.mymall.model.UmsPermission;
import com.hzf.mymall.model.UmsRolePermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author：010980380
 * @date:2020-10-28
 * @verison:1.0.0
 * @description：自定义角色权限关系管理Dao
 */

public interface UmsRolePermissionRelationDao {
    /**
     * 批量插入角色和权限关系
     * @param list
     * @return int
     * @author huangzifan
     * @since 2020-10-28 16:50
     */
    int insertList(@Param("list") List<UmsRolePermissionRelation> list);

    /**
     * 根据角色获取权限
     * @param roleId
     * @return java.util.List<UmsPermission>
     * @author huangzifan
     * @since 2020-10-28 16:50
     */
    List<UmsPermission> getPermissionList(@Param("roleId") Long roleId);
}
