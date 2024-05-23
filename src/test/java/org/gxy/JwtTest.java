package org.gxy;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("id", "1");
        claims.put("username", "张三");
        //生成jwt代码
        String token = JWT.create()
                .withClaim("user", claims)  //添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))  //添加过期时间
                .sign(Algorithm.HMAC256("gxy "));  //指定算法，配置密钥
        System.out.println(token);
    }

    @Test
    public void testParse(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7ImlkIjoiMSIsInVzZXJuYW1lIjoi5byg5LiJIn0sImV4cCI6MTcxNjQ3Njg3MX0." +
                "_qI81wwo6ia3SByozDINRznkI3QJqhKMvodhl2V_Wcw";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("gxy ")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
