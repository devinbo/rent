package com.xxz.rent.service.impl;

import com.xxz.rent.dto.UmsPermissionNode;
import com.xxz.rent.mapper.UmsPermissionMapper;
import com.xxz.rent.mapper.UmsRolePermissionRelationMapper;
import com.xxz.rent.model.UmsPermission;
import com.xxz.rent.model.UmsPermissionExample;
import com.xxz.rent.model.UmsRolePermissionRelation;
import com.xxz.rent.service.UmsPermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 后台用户权限管理Service实现类
 *
 * @author macro
 * @date 2018/9/29
 */
@Service
public class UmsPermissionServiceImpl implements UmsPermissionService {
    @Autowired
    private UmsPermissionMapper permissionMapper;

    @Autowired
    private UmsRolePermissionRelationMapper rolePermissionRelationMapper;

    @Override
    public int create(UmsPermission permission) {
        permission.setStatus(1);
        permission.setCreateTime(new Date());
        int count = permissionMapper.insertSelective(permission);
        //关联到管理员权限上
        UmsRolePermissionRelation umsRolePermissionRelation = new UmsRolePermissionRelation();
        umsRolePermissionRelation.setPermissionId(permission.getId());
        //管理员角色ID默认为1
        umsRolePermissionRelation.setRoleId(1L);
        rolePermissionRelationMapper.insert(umsRolePermissionRelation);
        return count;
    }

    @Override
    public int update(Long id, UmsPermission permission) {
        permission.setId(id);
        return permissionMapper.updateByPrimaryKey(permission);
    }

    @Override
    public int delete(List<Long> ids) {
        UmsPermissionExample example = new UmsPermissionExample();
        example.createCriteria().andIdIn(ids);
        return permissionMapper.deleteByExample(example);
    }

    @Override
    public List<UmsPermissionNode> treeList(String name) {
        UmsPermissionExample umsPermissionExample = new UmsPermissionExample();
        umsPermissionExample.createCriteria().andStatusEqualTo(1);
        if(!Objects.isNull(name)) {
            umsPermissionExample.getOredCriteria().get(0).andNameLike("%" + name + "%");
        }
        umsPermissionExample.setOrderByClause("sort desc");
        List<UmsPermission> permissionList = permissionMapper.selectByExample(umsPermissionExample);
        List<UmsPermissionNode> result = permissionList.stream()
                .filter(permission -> Objects.equals(permission.getPid(), 0L))
                .map(permission -> covert(permission,permissionList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<UmsPermission> list() {
        return permissionMapper.selectByExample(new UmsPermissionExample());
    }

    @Override
    public int deletePerm(Long id) {
        UmsPermissionExample example = new UmsPermissionExample();
        example.createCriteria().andIdEqualTo(id);
        example.or(example.createCriteria().andPidEqualTo(id));
        UmsPermission umsPermission = new UmsPermission();
        umsPermission.setStatus(0);
        return permissionMapper.updateByExampleSelective(umsPermission, example);
    }

    /**
     * 将权限转换为带有子级的权限对象
     * 当找不到子级权限的时候map操作不会再递归调用covert
     */
    private UmsPermissionNode covert(UmsPermission permission,List<UmsPermission> permissionList){
        UmsPermissionNode node = new UmsPermissionNode();
        BeanUtils.copyProperties(permission,node);
        List<UmsPermissionNode> children = permissionList.stream()
                .filter(subPermission -> Objects.equals(subPermission.getPid(), permission.getId()))
                .map(subPermission -> covert(subPermission,permissionList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
