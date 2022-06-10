package com.users.users.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Predicate;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RoundFunction {

    public static BigDecimal normalizarValorMontos(BigDecimal valorDolar) {
        return  valorDolar.setScale(BigDecimal.ZERO.intValue(),
                (valorDolar.remainder(BigDecimal.ONE).compareTo(ConstantUtil.VALOR_REDONDEO) >= 0)? RoundingMode.CEILING:RoundingMode.FLOOR);
    }


    public static <P1> void validacionFunction(P1 p1, Predicate<P1> predicate, ErrorValidacion error){
        if(predicate.test(p1)) {
            ErrorUtil ErroresUtil;
            throw ErrorUtil.crearErrorValidacion(error.getCodigo(),error.getDescripcion());
        }
    }
}
