package com.users.users.utils;

import com.users.users.dto.ResponseDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseUtil {

    public static ResponseEntity<Object> buildResponse (String message, HttpStatus httpStatus ) {
        ResponseDTO result = ResponseDTO.builder().message(message).build();
        return new ResponseEntity<>(result, httpStatus);
    }
}
