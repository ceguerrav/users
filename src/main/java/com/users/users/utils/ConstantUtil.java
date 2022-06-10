package com.users.users.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantUtil {

    public static final String PASS_REQUIRED = "Password es requerido";
    public static final String PASS_MUST_VALID = "Formato válido de Password: Una Mayuscula, letras minúsculas, y dos numeros)";
    public static final String EMAIL_REQUIRED = "Email es requerido";
    public static final String EMAIL_MUST_VALID = "Email debe ser válido";
    public static final String USER_REQUIRED = "Usuario es requerido";
    public static final String NO_VALID_TOKEN = "Token no válido";
    public static final String ERROR_MESSAGE = "Ha ocurrido un error: ";
    public static final String USER_PASS_NO_VALID = "Usuario y/o contraseña inválida";
    public static final String TOKEN_MESSAGE = "Token: ";
    public static final String TOKEN_VALID = "Token válido";
    public static final BigDecimal VALOR_REDONDEO = new BigDecimal("0.5");

}
