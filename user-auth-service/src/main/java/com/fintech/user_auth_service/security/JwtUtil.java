package com.fintech.user_auth_service.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    // 1. Fixed Secret Key (Taaki server restart hone par token fail na ho)
    private final String SECRET_KEY = "mySecureSecretKeyForFintechUserAuthService2026!";
    private final long jwtExpirationMs = 3600000; // 1 Ghanta

    // 2. Token Banane Ka Function
    public String generateToken(String email) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .subject(email) // Naye version mein 'setSubject' ki jagah 'subject'
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key) // Naya signing method
                .compact();
    }

    // 3. Token Kholne (Decode) Karne Ka Function (Aaj ke Day 9 ke liye zaroori hai)
    public String extractEmail(String token) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        return Jwts.parser()
                .verifyWith(key) // Check karega ki token asli hai ya nakli
                .build()
                .parseSignedClaims(token) // Token ko khola
                .getPayload() // Data wala hissa nikala
                .getSubject(); // Andar se Email nikal liya
    }
}