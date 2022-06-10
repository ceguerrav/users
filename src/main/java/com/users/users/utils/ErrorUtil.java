package com.users.users.utils;

import com.users.users.exception.error.ErrorDto;
import com.users.users.exception.error.ErrorExceptionResource;
import com.users.users.exception.error.ErrorTecnicoException;
import org.springframework.http.HttpStatus;

public class ErrorUtil {
    private ErrorUtil(){}

    public static ErrorExceptionResource crearErrorValidacion(String codigo, String detalle) {
        return new ErrorExceptionResource(HttpStatus.BAD_REQUEST, ErrorDto.builder().codigo(codigo).mensaje(detalle).build());
    }

    public static ErrorTecnicoException crearErrorTecnico(Throwable throwable) {
        return new ErrorTecnicoException(throwable, HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}
