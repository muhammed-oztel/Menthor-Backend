package com.menthor.LoginApi.auth;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TokenManager {

    // private static final String secretKey = "Gizli_Anahtar_Budur";
    private static final int validity = 5 * 60 * 1000; // Geçerlilik süresi
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username){

        return Jwts.builder()
                .setSubject(username) // Öznesi kim.
                .setIssuer("Admin") // Kim imzaladı
                .setIssuedAt(new Date(System.currentTimeMillis())) // hangi tarihte imzalandı.
                .setExpiration(new Date(System.currentTimeMillis() + validity)) // Ne kadar zamanı var.
                .signWith(key) // Key girişi.
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
