package jwt;

import io.jsonwebtoken.*;

import java.util.Date;

/**
 *  json web token
 */
public class JwtServer {
    private  static final String SECRET_KEY = "secret-key";

    /**
     * 生成 jwt 字符串
     * @return
     */
    public String bildJwt(){
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .setExpiration(new Date())
                .claim("key", "value")
                .compact();
        return jwt;
    }

    public boolean isJwtValid(String jwt) {
        try {
            //解析JWT字符串中的数据，并进行最基础的验证
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)//SECRET_KEY是加密算法对应的密钥，jjwt可以自动判断机密算法
                    .parseClaimsJws(jwt)//jwt是JWT字符串
                    .getBody();
            String vaule = claims.get("key", String.class);//获取自定义字段key
            //判断自定义字段是否正确
            if ("vaule".equals(vaule)) {
                return true;
            } else {
                return false;
            }
        }
        //在解析JWT字符串时，如果密钥不正确，将会解析失败，抛出SignatureException异常，说明该JWT字符串是伪造的
        //在解析JWT字符串时，如果‘过期时间字段’已经早于当前时间，将会抛出ExpiredJwtException异常，说明本次请求已经失效
        catch (SignatureException |ExpiredJwtException e) {
            return false;
        }
    }
}
