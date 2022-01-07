package com.users.users.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.regex.Pattern;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class FormatValidatorUtil {

    public static boolean validateEmail(String email) {
        Objects.requireNonNull(email, ConstantUtil.EMAIL_REQUIRED);
        log.info("Valida email: {}", email);


        String expresionRegularEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if (Pattern.compile(expresionRegularEmail).matcher(email).find()) {
            log.info("MAILVALIDATOR - validateEmail - Mail {} OK", email);
            return Boolean.TRUE;

        } else {
            log.info("MAILVALIDATOR - validateEmail - Mail {} no valido no se realiza envio de correo ", email);

        }
        return Boolean.FALSE;
    }


    public static boolean validaPassword(String pass) {
        Objects.requireNonNull(pass, ConstantUtil.PASS_REQUIRED);

        String expresionRegularPass = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{5,}$";

        if (Pattern.compile(expresionRegularPass).matcher(pass).find()) {
            log.info("MAILVALIDATOR - validateEmail - Mail {} OK", pass);
            return Boolean.TRUE;

        } else {
            log.info("MAILVALIDATOR - validateEmail - Mail {} no valido no se realiza envio de correo ", pass);

        }

        return Boolean.FALSE;
    }
}
