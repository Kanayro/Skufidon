package org.example.searchingservice.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.example.searchingservice.dto.JWTDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

    @Value("${jwt_secret}")
    private String secret;

    public JWTDTO validateTokenAndRetrieveClaim(String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("User details")
                .withIssuer("Kanayro")
                .build();

        DecodedJWT jwt = verifier.verify(token);

        JWTDTO client = new JWTDTO();
        client.setId(jwt.getClaim("id").asInt());
        client.setUsername(jwt.getClaim("username").asString());
        client.setRole(jwt.getClaim("role").asString());

        return client;
    }

    public String getJWT(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");

        if(authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")){
            return authHeader.substring(7);
        }else{
            return null;
        }
    }
}
