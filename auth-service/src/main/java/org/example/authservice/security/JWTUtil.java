package org.example.authservice.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.example.authservice.models.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt_secret}")
    private String secret;

    public String generateToken(Client client){
        Date expirationDate = Date.from(ZonedDateTime.now().plusMinutes(60).toInstant());

        return JWT.create().withSubject("User details")
                .withClaim("id",client.getId())
                .withClaim("username",client.getUsername())
                .withClaim("role",client.getRole())
                .withIssuedAt(new Date())
                .withIssuer("Kanayro")
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(secret));
    }

    public Client validateTokenAndRetrieveClaim(String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("User details")
                .withIssuer("Kanayro")
                .build();

        DecodedJWT jwt = verifier.verify(token);

        Client client = new Client();
        client.setId(jwt.getClaim("id").asInt());
        client.setUsername(jwt.getClaim("username").asString());
        client.setRole(jwt.getClaim("role").asString());

        return client;
    }
}
