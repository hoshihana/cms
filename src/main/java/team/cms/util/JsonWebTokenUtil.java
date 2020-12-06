package team.cms.util;

import io.jsonwebtoken.*;
import org.bouncycastle.util.encoders.Base64;
import team.cms.entity.Account;
import team.cms.entity.enums.Role;
import team.cms.result.JWTParseResult;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

public class JsonWebTokenUtil {

    final static String JWT_SECRET = "NCUCSJAVAWEB";  // 密匙（未加密）

    final static long JWT_TTL = 15L * 24L * 3600L * 1000L;

    public static String createJWT(Account account) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long curMillis = System.currentTimeMillis();
        Date cur = new Date(curMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .claim("accountId", account.getId())
                .claim("username", account.getUsername())
                .claim("role", account.getRole())
                .setIssuer("server")    // 签发者
                .setIssuedAt(cur)       // 签发时间
                .signWith(signatureAlgorithm, secretKey);   // 签名算法以及密匙
        long expMillis = curMillis + JWT_TTL;
        Date expDate = new Date(expMillis);
        builder.setExpiration(expDate); // 过期时间
        return builder.compact();
    }

    public static JWTParseResult parseJWT(String jwt) {
        if(jwt == null)
            return new JWTParseResult(false, "未携带Token", null, null, null);
        Claims claims;
        try {
            SecretKey secretKey = generalKey();
            claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(jwt)
                    .getBody();
            return new JWTParseResult(true, "Token解析成功", (Integer)claims.get("accountId"), (String)claims.get("username"), Role.valueOf((String)claims.get("role")));
        } catch (ExpiredJwtException e) {
            return  new JWTParseResult(false, "Token已过期", null, null, null);
        } catch (Exception e) {
            return new JWTParseResult(false, "Token为空或非法", null, null, null);
        }
    }

    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.decode(JWT_SECRET);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }
}
