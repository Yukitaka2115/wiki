package com.solaluna.wiki.pojo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "yukitaka.jwt")
public class JwtUtils {

    private static String secret;

    private long expire;

    private String header;

    /**
     * jwt 可以生成 一个加密的token，做为用户登录的令牌，当用户登录成功之后，发放给客户端。
     * 请求需要登录的资源或者接口的时候，将token携带，后端验证token是否合法。
     * jwt由三部分组成：A.B.C
     * A：Header，{"type":"JWT","alg":"HS256"} 固定
     * B：payload，存放信息，比如，用户id，过期时间等等，可以被解密，不能存放敏感信息
     * C:  签证，A和B加上秘钥 加密而成，只要秘钥不丢失，可以认为是安全的。
     * jwt 验证，主要就是验证C部分 是否合法。
     */
    public String createToken(long userId) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(String.valueOf(userId)) //设置body
                .setIssuedAt(nowDate) //创建时间
                .setExpiration(expireDate) //过期时间
                .signWith(SignatureAlgorithm.HS512, secret) //签发算法
                .compact();
    }

    public static String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public static int getUserRoleFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        int role = (int) claims.get("role");
        return role;
    }


    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
