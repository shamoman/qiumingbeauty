/**
 * @(#) ${FILE_NAME} 1.0  2018:04:29
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.controller;

import com.alibaba.fastjson.JSON;
import com.qiuming.beauty.domain.SysUser;
import com.qiuming.beauty.dto.LoginDto;
import com.qiuming.beauty.dto.RestResponse;
import com.qiuming.beauty.repository.SysUserRepository;
import com.qiuming.beauty.utils.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import static com.qiuming.beauty.utils.AuthUtils.HEADER_STRING;
import static com.qiuming.beauty.utils.AuthUtils.TOKEN_PREFIX;

/**
 *
 * @description: 登陆模块
 * @author: ji.shamo
 * @create: 2018-04-29 16:44
 **/

@RestController
@CrossOrigin
@RequestMapping(value = "/qiuming/beauty/auth")
public class LoginController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysUserRepository sysUserRepository;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @CrossOrigin
    public RestResponse login(HttpServletResponse res,  @RequestBody LoginDto dto) {
        logger.info("登陆参数 | {}", JSON.toJSONString(dto));
        if (null == dto || StringUtils.isEmpty(dto.getUsername()) || StringUtils.isEmpty(dto.getPassword())){
            return new RestResponse(-1, "请输入正确的用户名密码");
        }
        SysUser sysUser = sysUserRepository.findByUsername(dto.getUsername());
        if (null == sysUser){
            return new RestResponse(-1, "该用户不存在");
        }
        if (!sysUser.getPassword().equals(dto.getPassword())){
            return new RestResponse(-1, "您输入的密码错误");
        }
        String auth = AuthUtils.enCodeAuth(sysUser);
        logger.info("生成用户auth | {}", auth);
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + auth);
        return new RestResponse(auth);
    }
}
