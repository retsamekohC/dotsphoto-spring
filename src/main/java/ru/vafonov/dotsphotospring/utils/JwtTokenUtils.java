package ru.vafonov.dotsphotospring.utils;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtTokenUtils {

    public static String getUserNameFromToken(JwtAuthenticationToken jwtAuthenticationToken) {
        return jwtAuthenticationToken.getToken().getClaimAsString("preferred_username");
    }
}
