package com.users.users.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class PasswordException extends Exception  {
    private static final long serialVersionUID = 1L;

    public PasswordException(String message) {
        super(message);
    }
}
