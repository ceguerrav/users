package com.users.users.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RoundFunction {

    public static BigDecimal normalizarValorMontos(BigDecimal valorDolar) {
        return  valorDolar.setScale(BigDecimal.ZERO.intValue(),
                (valorDolar.remainder(BigDecimal.ONE).compareTo(ConstantUtil.VALOR_REDONDEO) >= 0)? RoundingMode.CEILING:RoundingMode.FLOOR);
    }

}
