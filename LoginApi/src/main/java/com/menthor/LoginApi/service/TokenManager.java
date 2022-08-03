package com.menthor.LoginApi.service;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.security.Key;
import java.util.Date;

@Service
public class TokenManager {
    private static final int validity = 5 * 60 * 1000;
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("Admin")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(key)
                .compact();
    }
    public boolean tokenValidate(String token){
        return getUsernameFromToken(token) != null && isExpired(token);
    }
    public String getUsernameFromToken(String token){
        Claims claims = getClaims(token);
        return claims.getSubject();
    }
    public boolean isExpired(String token){
        Claims claims = getClaims(token);
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }
    private Claims getClaims(String token){
        return  Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }
}
