package com.users.users.exception.error;

import lombok.Getter;

@Getter
public class ErrorTecnicoException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -4607986199110034184L;

    private final Throwable throwable;

    private final String codigo;

    private final String mensajeDebug;


    public ErrorTecnicoException(Throwable throwable, String codigo) {
        super(throwable);
        this.throwable = throwable;
        this.codigo = codigo;
        this.mensajeDebug = "Exception: "+throwable.getClass().getName()+", cause: "+throwable.getCause() +", message "+throwable.getMessage();
    }

    public ErrorTecnicoException(Throwable throwable, String codigo, String mensajeDebug) {
        super(throwable);
        this.throwable = throwable;
        this.codigo = codigo;
        this.mensajeDebug = mensajeDebug;
    }
}
