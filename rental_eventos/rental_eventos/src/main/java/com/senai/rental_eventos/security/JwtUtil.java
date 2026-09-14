package com.senai.rental_eventos.security;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component 
public class JwtUtil {
    
    private final SecretKey chave = Jwts.SIG.HS256.key().build();

        public String gerarToken(String email) {
        return Jwts.builder()
                .subject(email)
                .signWith(chave)
                .compact();
    }

        public String getEmail(String token) {
        return Jwts.parser()
                .verifyWith(chave)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

}
