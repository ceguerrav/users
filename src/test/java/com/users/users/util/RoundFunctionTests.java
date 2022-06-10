package com.users.users.util;

import com.users.users.utils.RoundFunction;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundFunctionTests {



    @Test
    void roundUpDollar(){
        BigDecimal valorDolar = new BigDecimal("863.54");
        BigDecimal expected = new BigDecimal("864");
        BigDecimal result = RoundFunction.normalizarValorMontos(valorDolar);
        assertThat(result).isNotNull().isEqualTo(expected);
    }

    @Test
    void roundUpJustDollar(){
        BigDecimal valorDolar = new BigDecimal("863.50");
        BigDecimal expected = new BigDecimal("864");
        BigDecimal result = RoundFunction.normalizarValorMontos(valorDolar);
        assertThat(result).isNotNull().isEqualTo(expected);
    }

    @Test
    void roundDownDollar(){
        BigDecimal valorDolar = new BigDecimal("863.45");
        BigDecimal expected = new BigDecimal("863");
        BigDecimal result = RoundFunction.normalizarValorMontos(valorDolar);
        assertThat(result).isNotNull().isEqualTo(expected);
    }




}
