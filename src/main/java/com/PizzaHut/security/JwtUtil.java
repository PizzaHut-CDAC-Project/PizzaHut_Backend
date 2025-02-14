package com.PizzaHut.security;

import java.security.Key;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    
    @Value("${jwt.token.expiration.millis}")
    private long jwtExpiration;
    
    @Value("${jwt.token.secret}")
    private String jwtSecret;
    
    private Key jwtKey;
    
    @PostConstruct
    public void init() {
        jwtKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }
    
    public String createToken(Authentication auth) {
        CustomUserDetails user = (CustomUserDetails) auth.getPrincipal(); 
        String subject = user.getUsername(); // Use email/username

        String s = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(jwtKey, SignatureAlgorithm.HS256)
                .compact();
        
        return s;
    }

    
    public String extractUsername(String token) {
    	 System.out.println(Jwts.parserBuilder()
                 .setSigningKey(jwtKey)
                 .build()
                 .parseClaimsJws(token)
                 .getBody()
                 .getSubject());
        return Jwts.parserBuilder()
                .setSigningKey(jwtKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
       
    }
    
    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(jwtKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}
