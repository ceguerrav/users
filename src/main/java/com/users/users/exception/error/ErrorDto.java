package com.users.users.exception.error;


import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
//import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;

//import cl.bci.mscore.base.config.DebugConfig;
import lombok.Builder;
import lombok.Data;


/**
 * @author Fabián Silva Ortiz
 *
 * <p>
 * <B> Todos los derechos reservados por Banco de Crédito e Inversiones </B>
 * <p>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@ApiModel(value = "ErrorResponse")
public class ErrorDto {

    @NotNull
    @NotEmpty
    //@ApiModelProperty(value = "Código que identifica el tipo de error")
    private String codigo;

    @NotNull
    @NotEmpty
    //@ApiModelProperty(value = "Mensaje con detalle del error")
    private String mensaje;

    //@ApiModelProperty(hidden = true)
    private StringBuilder info;

    //@ApiModelProperty(hidden = true)
    private String debug;


    public static class ErrorDtoBuilder {
        public ErrorDtoBuilder debug(String value) {
            /*
            if (DebugConfig.isDebug()) {
                debug = value;
            }
             */
            return this;
        }

        /**
         *
         * @deprecated Usar clase ValidacionDto para informar errores de validacion de campos
         * @param erroresValidacion
         *
         * @return
         */
        @Deprecated
        public ErrorDtoBuilder info(List<ErrorValidacion> erroresValidacion) {
            if (null != erroresValidacion) {
                int largo = erroresValidacion.size();

                if (largo > 0) {
                    this.info = new StringBuilder();
                    this.info.append("[");
                    ErrorValidacion error;
                    for (int i = 0; i < largo; i++) {
                        error = erroresValidacion.get(i);
                        if (i >= 1) {
                            this.info.append(" | ");
                        }
                        this.info.append(error.getAtributo());
                        this.info.append(":");
                        this.info.append(error.getMensaje());
                    }
                    this.info.append("]");
                }

            } else {
                this.info = null;
            }
            return this;
        }

    }


}
