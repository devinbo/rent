package com.xxz.rent.service;

import com.xxz.rent.dto.PageParam;
import com.xxz.rent.dto.UmsAdminParam;
import com.xxz.rent.model.UmsAdmin;
import com.xxz.rent.model.UmsPermission;
import com.xxz.rent.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台管理员Service
 * Created by macro on 2018/4/26.
 */
@Transactional(rollbackFor = Exception.class)
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    public UmsAdmin getCurrLoginInfo();
    /**
     * 刷新token的功能
     * @param oldToken 旧的token
     */
    String refreshToken(String oldToken);

    /**
     * 根据用户id获取用户
     */
    UmsAdmin getItem(Long id);

    /**
     * 根据用户名或昵称分页查询用户
     */
    List<UmsAdmin> list(String name, PageParam pageParam);

    /**
     * 修改指定用户信息
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 删除指定用户
     */
    int delete(Long id);

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 获取用户对于角色
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 修改用户的+-权限
     */
    int updatePermission(Long adminId, List<Long> permissionIds);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);

    /**  功能描述 <br>
     * <冻结账户>
     *
     * @param ids
     * @param blockStatus
     * @return int
     * @date 2019-06-05 14:11
     */
    int updateBlockStatus(List<Long> ids, Integer blockStatus);

    /**  功能描述 <br>
     * <修改密码>
     *
     * @param oldPassword
     * @param newPassword
     * @return int
     * @date 2019-06-10 14:39
     */
    int updatePassword(String oldPassword, String newPassword);

    /**  功能描述 <br>
     * <从redis中加载用户>
     *
     * @param username
     * @return com.xxz.rent.model.UmsAdmin
     * @date 2019-06-10 17:40
     */
    UmsAdmin getUmsAdminByRedisWithUserName(String username);

    /**  功能描述 <br>
     * <从redis中加载权限信息>
     *
     * @param id
     * @return java.util.List<com.xxz.rent.model.UmsPermission>
     * @date 2019-06-10 17:40
     */
    List<UmsPermission> getUmsPermissionByRedis(Long id);

}
