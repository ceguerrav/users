package com.users.users.utils;

import com.users.users.dto.UserDTO;
import com.users.users.exception.EmailException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationUtil {

    public static void validateUserDTO(UserDTO user) throws EmailException {

        Objects.requireNonNull(user, ConstantUtil.PASS_REQUIRED);

        boolean isValid = Optional.ofNullable(user.getEmail())
            .map(FormatValidatorUtil::validateEmail)
            .orElseThrow(() -> new EmailException(ConstantUtil.EMAIL_REQUIRED));

        if (!isValid) {
            throw new EmailException(ConstantUtil.EMAIL_MUST_VALID);
        }

        isValid = Optional.ofNullable(user.getPassword())
            .map(FormatValidatorUtil::validaPassword)
            .orElseThrow(() -> new EmailException(ConstantUtil.PASS_REQUIRED));

        if (!isValid) {
            throw new EmailException(ConstantUtil.PASS_MUST_VALID);
        }
    }


}
