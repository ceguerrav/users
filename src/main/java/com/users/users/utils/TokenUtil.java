package com.users.users.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenUtil {

    /**
     * Tiempo de caducidad 30 segundos
     */
    protected static final long EXPIRE_TIME = 30 * 1000;
    /**
     * Clave privada de token, UUID se utiliza para regenerar una clave privada para cada llamada
     */
    protected static final String PRIVATE_SECRET = UUID.randomUUID().toString();
    // Documento de referencia: https://github.com/auth0/java-jwt

    /**
     * Emisión de token de firma
     *
     * Cuenta de usuario de cuenta @param
     * ID de cuenta @param userId
     * @return String token signature
     */
    public static String signToken(String account, String userId) {
        try {
            // fecha de caducidad
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

            // Referencia: https://github.com/auth0/java-jwt#create-and-sign-a-token

            // Clave privada y cifrado con HS256
            Algorithm algorithm = Algorithm.HMAC256(PRIVATE_SECRET);

            // configuración de información del encabezado
            Map <String, Object> header = new HashMap <String, Object> (2); // establece provisionalmente la capacidad en 2
            header.put("type", "JWT");
            header.put("alg", "HS256");

            // Generar firma, con parámetros
            return JWT.create()
                .withHeader(header)
                .withClaim("loginname", account)
                .withClaim("userId", userId)
                .withExpiresAt(date)
                .sign(algorithm);
            // devuelve la cadena de token generada
        } catch (JWTCreationException e) {
            return null;
        }
    }
    // Referencia: https://github.com/auth0/java-jwt#verify-a-token

    /**
     * Verificar token
     *
     * Información de token generada por el token @param
     * @return devuelve un valor booleano (verdadero válido | falso inválido)
     */
    public static boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(PRIVATE_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }

    /**
     * Parse token
     * El token generado por @param token
     * @return devuelve el objeto DecodedJWT
     */
    public static DecodedJWT ParsingToken(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt;
        } catch (JWTDecodeException exception) {
            return null;
        }
    }

}
