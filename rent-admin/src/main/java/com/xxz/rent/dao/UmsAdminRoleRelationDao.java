package com.xxz.rent.dao;

import com.xxz.rent.model.UmsAdminRoleRelation;
import com.xxz.rent.model.UmsPermission;
import com.xxz.rent.model.UmsRole;
import com.xxz.rent.model.UmsAdminRoleRelation;
import com.xxz.rent.model.UmsPermission;
import com.xxz.rent.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 *
 * @author xhb
 * @date 2018/10/8
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 批量插入用户角色关系
     * @param adminRoleRelationList
     * @return int
     */
    int insertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);

    /**
     * 获取用于所有角色
     * @param adminId
     * @return java.util.List<com.xxz.rent.model.UmsRole>
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有权限
     * @param adminId
     * @return java.util.List<com.xxz.rent.model.UmsPermission>
     */
    List<UmsPermission> getRolePermissionList(@Param("adminId") Long adminId);

    /**  功能描述 <br>
     * <获取用户所有权限>
     *
     * @param adminId
     * @return java.util.List<com.xxz.rent.model.UmsPermission>
     * @date 2019-06-05 14:10
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
