package com.senai.rental_eventos.services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;

@Service
public class JwtService {
    public String gerarToken(Authentication authentication){

        return Jwts.builder()
                .subject(authentication.getName())
                .signWith(chave)
                .compact();
    }

    private final SecretKey chave = Jwts.SIG.HS256.key().build();
}
