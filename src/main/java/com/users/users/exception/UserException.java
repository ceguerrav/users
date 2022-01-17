package com.users.users.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class UserException  extends Exception  {
    private static final long serialVersionUID = 1L;

    public UserException(String message) {
        super(message);
    }
}
