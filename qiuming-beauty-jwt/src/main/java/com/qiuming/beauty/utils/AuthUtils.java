/**
 * @(#) ${FILE_NAME} 1.0  2018:05:02
 * <p>
 * Copyright (c) 2018, YUNXI. All rights reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.qiuming.beauty.utils;

import com.qiuming.beauty.domain.SysUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 *
 * @description: 授权Util
 * @author: ji.shamo
 * @create: 2018-05-02 21:25
 **/
public class AuthUtils {
    public static final long EXPIRATIONTIME = 1000*60*60*24*1; // 1 days
    public static final String SECRET = "ThisIsASecret";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";

    public static String enCodeAuth(SysUser user){
        String JWT = Jwts.builder()
                .setSubject(user.getId().toString())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return JWT;
    }
}
