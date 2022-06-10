package com.users.users.exception.error;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author BCI
 */
public class ErrorExceptionResource extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;
    private final HttpStatus httpStatus;
    private final Object object; //NOSONAR


    public ErrorExceptionResource(HttpStatus httpStatus, Object object) {
        super(httpStatus.getReasonPhrase());
        this.httpStatus = httpStatus;
        this.object = object;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }


    public Object getBody(){
        return object;
    }
    
    public String getCodigo() {
    	if(object instanceof ErrorDto) {
    		ErrorDto error = (ErrorDto) this.object;
    		return error.getCodigo();
    	}
    	return "";
    }

    public String getMensaje() {
    	if(object instanceof ErrorDto) {
    		ErrorDto error = (ErrorDto) this.object;
    		return error.getMensaje();
    	}
    	return "";
    }
    
}
