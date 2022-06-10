package com.users.users.exception.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorValidacion {

    private static final long serialVersionUID = 6054024052246145782L;
    private String atributo;
    private String mensaje;
}
