package com.xxz.rent.service;

import com.xxz.rent.dto.UmsPermissionNode;
import com.xxz.rent.model.UmsPermission;

import java.util.List;

/**
 * 后台用户权限管理Service
 * Created by macro on 2018/9/29.
 */
public interface UmsPermissionService {
    /**
     * 添加权限
     */
    int create(UmsPermission permission);

    /**
     * 修改权限
     */
    int update(Long id,UmsPermission permission);

    /**
     * 批量删除权限
     */
    int delete(List<Long> ids);

    /**
     * 以层级结构返回所有权限
     * @param name
     */
    List<UmsPermissionNode> treeList(String name);

    /**
     * 获取所有权限
     */
    List<UmsPermission> list();

    /**  功能描述 <br>
     * <删除指定权限及其子权限>
     *
     * @param id
     * @return int
     * @date 2019-06-11 18:22
     */
    int deletePerm(Long id);
}
