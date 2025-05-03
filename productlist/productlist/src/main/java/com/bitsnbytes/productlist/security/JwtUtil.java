package com.bitsnbytes.productlist.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Component
public class JwtUtil {


    private static String secreatKey;

    JwtUtil(){
        SecureRandom random=new SecureRandom();
        byte[] key=new byte[32];   //256 bit
        random.nextBytes(key);
        secreatKey= Base64.getEncoder().encodeToString(key);
    }

    public String generateToken(String username, List<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*2))
                .signWith(getSignedKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getSignedKey(){
        byte[] keyBytes= Decoders.BASE64.decode(secreatKey);
        return Keys.hmacShaKeyFor(keyBytes);

    }
    public boolean validToken(String token, String username) {

      //  String username = "username";
        return (extractUsername(token).equals(username) && !isTokenExperied(token));
    }
    public String extractUsername(String token){
        return extractClaims(token,Claims::getSubject);

    }
    public Date extractExperation(String token) {
        return extractClaims(token, Claims::getExpiration);
    }
    public boolean isTokenExperied(String token) {
        return extractExperation(token).before(new Date());
    }
    public List<String> extracRole(String token) {
        return extractClaims(token,claims -> claims.get("roles",List.class));
    }
    public <T> T extractClaims(String token, Function<Claims,T> claimsResolver){
        final Claims claims=Jwts.parser()
                .setSigningKey(getSignedKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
                return  claimsResolver.apply(claims);

    }
}