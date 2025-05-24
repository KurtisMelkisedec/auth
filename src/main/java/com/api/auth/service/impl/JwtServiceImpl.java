package com.api.auth.service.impl;

import com.api.auth.service.IJwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements IJwtService {
    @Value("${jwt.secret}")
    private String SECRET;
    @Override
    public String generateToken(String username, Collection<? extends GrantedAuthority> authorities) {
        Map<String,Object> claims=new HashMap<>();
        claims.put("roles",authorities);

        return createToken(username,claims);
    }

    @Override
    public String createToken(String username, Map<String, Object> claims) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt( new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+(3*3600*1000)))
                .signWith(getSigneKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public String createToken(String username) {
        return Jwts.builder()
                .setClaims(new HashMap<String, Object>())
                .setSubject(username)
                .setIssuedAt( new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+(3*3600*1000)))
                .signWith(getSigneKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public Key getSigneKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));
    }

    @Override
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigneKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    @Override
    public Date extractExpirationDate(String token) {
        return extractAllClaims(token).getExpiration();
    }

    @Override
    public Boolean isTokenExpired(String token) {
        return extractExpirationDate(token).before(new Date());
    }

    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username=extractAllClaims(token).getSubject();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
