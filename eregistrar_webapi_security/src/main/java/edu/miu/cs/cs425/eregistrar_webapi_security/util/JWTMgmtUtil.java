package edu.miu.cs.cs425.eregistrar_webapi_security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * This is a utility class for management
 * of the JSON Web Token. It contains methods
 * for generating, extracting/decoding and validating JWT tokens
 */
@Service
public class JWTMgmtUtil {

    //private String secret ="cs425-swe";

    private final  byte[] secret = Base64.getDecoder()
            .decode("jZ5OyIDw8O+HKXZX4z0YtLQWR66Bj80KWV5ruM1ie5Q=");
   public String extractUsername(String token){
       return extractClaim(token, Claims::getSubject);
   }
public Date extractExpiration(String token){
       return  extractClaim(token,Claims::getExpiration);
}
    public  <T> T extractClaim(String token, Function<Claims ,T> claimsResolver) {
       final  Claims claims=extractAllClaims(token);
       return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
       return  Jwts.parser()
               .setSigningKey(secret)
               .parseClaimsJws(token)
               .getBody();
    }
    private String createToken(Map<String,Object> claims, String subject){
      var now = Instant.now();
      return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(24, ChronoUnit.HOURS)))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())
                && !isTokenExpired(token));
    }

}
