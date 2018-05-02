package com.qiuming.beauty.service.impl;

import com.alibaba.fastjson.JSON;
import com.qiuming.beauty.constants.Constants;
import com.qiuming.beauty.domain.SysUser;
import com.qiuming.beauty.dto.RegisterDto;
import com.qiuming.beauty.dto.UserDto;
import com.qiuming.beauty.eo.SysUserInfoEo;
import com.qiuming.beauty.repository.SysUserInfoRepository;
import com.qiuming.beauty.repository.SysUserRepository;
import com.qiuming.beauty.service.IMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description: 用户信息Service层
 * @author: ji.shamo
 * @create: 2018-04-17 23:14
 **/
@Service("memberService")
public class MemberServiceImpl implements IMemberService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysUserRepository sysUserRepository;
    @Resource
    private SysUserInfoRepository sysUserInfoRepository;

    @Override
    public SysUser getMemberInfoById(Long memberId) {
       return sysUserRepository.findOne(memberId);
    }

    @Override
    public SysUser getMemberInfoByUserName(String userName) {
        return sysUserRepository.findByUsername(userName);
    }

    @Override
    public void addSysUser(RegisterDto dto) {
        logger.info("开始注册用户 | {}", JSON.toJSONString(dto));
        SysUser sysUser = new SysUser();
        sysUser.setPassword(dto.getPassword());
        sysUser.setUsername(dto.getUsername());
        sysUser.setUpdateTime(new Date());
        sysUser.setCreateTime(new Date());
        sysUser.setMobile(dto.getMobile());
        sysUserRepository.save(sysUser);
        SysUserInfoEo infoEo = new SysUserInfoEo();
        infoEo.setRealName(dto.getRealName());
        infoEo.setAccountId(sysUser.getId());
        infoEo.setAvatarUrl(Constants.AVURATE_URL);
        sysUserInfoRepository.save(infoEo);
    }

    @Override
    public void update(SysUser sysUser) {

    }

    @Override
    public void resetPwd(Long accountId, String password) {
        SysUser sysUser = new SysUser();
        sysUser.setId(accountId);
        sysUser.setPassword(password);
        sysUserRepository.save(sysUser);
    }

    @Override
    public UserDto getUserDetailByAccountId(Long accountId) {
        SysUser sysUser = sysUserRepository.findOne(accountId);
        SysUserInfoEo infoEo = sysUserInfoRepository.findSysUserInfoEoByAccountId(accountId);
        return new UserDto(sysUser, infoEo);
    }

    @Override
    public void updateUserDetail(UserDto dto) {
        SysUser sysUser = sysUserRepository.findOne(dto.accountId);
        sysUser.setMobile(dto.getMobile());
        SysUserInfoEo infoEo = sysUserInfoRepository.findSysUserInfoEoByAccountId(dto.getAccountId());
        infoEo.setNickName(dto.getUsername());
        infoEo.setId(infoEo.getId());
        infoEo.setAvatarUrl(dto.avatarUrl);
        sysUserInfoRepository.save(infoEo);
    }

    @Override
    public List<SysUser> findAllUser() {
        return sysUserRepository.findAll();
    }
}
