/**
 * @(#)${file_name} 1.0 ${date}
 * <p>
 * Copyright (c) 2017, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.controller;

import com.alibaba.fastjson.JSON;
import com.qiuming.beauty.config.TokenAuthenticationService;
import com.qiuming.beauty.constants.Constants;
import com.qiuming.beauty.constants.ExceptionEnum;
import com.qiuming.beauty.domain.SysUser;
import com.qiuming.beauty.dto.RegisterDto;
import com.qiuming.beauty.dto.RestResponse;
import com.qiuming.beauty.dto.UserDto;
import com.qiuming.beauty.service.IMemberService;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @description: 会员信息Controller接口
 * @author: ji.shamo
 * @create: 2018-04-17 23:02
 **/
@RestController
@CrossOrigin
@RequestMapping(value = "/qiuming/beauty/member")
public class MemberController {
    @Resource
    private IMemberService memberService;


    @RequestMapping(value = "/get/detail",method = RequestMethod.GET)
    public RestResponse getMemberInfo(HttpServletRequest request) {
        Long userId = TokenAuthenticationService.getUserId(request);
        System.out.println("userId:" + userId);
//        SysUser sysUser = memberService.getMemberInfoById(userId);
//        if (null == sysUser){
//            return new RestResponse(-1, "用户信息不存在");
//        }
        UserDto dto = memberService.getUserDetailByAccountId(userId);
        return  new RestResponse(dto);
    }

    @RequestMapping(value = "/username/exit",method = RequestMethod.GET)
    public RestResponse getMemberInfo(String username) {
        SysUser sysUser = memberService.getMemberInfoByUserName(username);
        if (null == sysUser){
            return RestResponse.SUCCESS;
        }
        return  new RestResponse(-1, "该用户名已经注册！");
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @CrossOrigin
    public RestResponse register(@RequestBody RegisterDto dto) {
        if (null == dto || StringUtils.isEmpty(dto.getConfirmPassword())
                || StringUtils.isEmpty(dto.getPassword()) || StringUtils.isEmpty(dto.getUsername())){
            return new RestResponse(ExceptionEnum.ERROR_PARAM.getCode(), ExceptionEnum.ERROR_PARAM.getMessage());
        }
        if (!dto.getPassword().equals(dto.getConfirmPassword())){
            return new RestResponse(ExceptionEnum.PASSWORD_DO_NOT_SAME.getCode(), ExceptionEnum.PASSWORD_DO_NOT_SAME.getMessage());
        }
        if (dto.getUsername().equalsIgnoreCase(Constants.ADMIN)){
            return new RestResponse(-1, "用户名非法");
        }
        memberService.addSysUser(dto);
        return  RestResponse.SUCCESS;
    }


}
