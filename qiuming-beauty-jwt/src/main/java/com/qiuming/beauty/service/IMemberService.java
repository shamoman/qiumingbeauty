package com.qiuming.beauty.service;

import com.qiuming.beauty.domain.SysUser;
import com.qiuming.beauty.dto.RegisterDto;
import com.qiuming.beauty.dto.UserDto;

import java.util.List;

/**
 * @(#)${file_name} 1.0 ${date}
 * <p>
 * Copyright (c) 2017, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
public interface IMemberService {
    /**
     * @return:
     * @Author: ji.shamo
     * @Date: 2018/4/17
     * @Param: memberId - 用户id
     */
    public SysUser getMemberInfoById(Long memberId);

    /**
     * 获取用户信息
     * @param userName - 用户名
     * @return
     */
    public SysUser getMemberInfoByUserName(String userName);

    /**
     * 新增用户
     * @param dto
     */
    public void addSysUser(RegisterDto dto);

    /**
     * 更新用户
     * @param sysUser - 更新用户账号信息
     */
    public void update(SysUser sysUser);

    /**
     * 重置密码
     * @param accountId - 账号id
     * @param password - 新密码
     */
    public void resetPwd(Long accountId, String password);

    /**
     * 查询用户详情
     * @param accountId - 账号id
     * @return
     */
    public UserDto getUserDetailByAccountId(Long accountId);

    /**
     * 更新用户
     * @param dto - 用户详情dto
     */
    public void updateUserDetail(UserDto dto);

    /**
     * 查询所有用户列表
     * @return
     */
    public List<SysUser> findAllUser();
}
