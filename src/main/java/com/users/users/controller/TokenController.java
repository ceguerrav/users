package com.users.users.controller;


import com.users.users.dto.ResponseDTO;
import com.users.users.dto.UserDTO;
import com.users.users.service.UserService;
import com.users.users.utils.ConstantUtil;
import com.users.users.utils.TokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping(value = "/token")
@RequiredArgsConstructor
public class TokenController {


    private final UserService userService;



    @GetMapping("/refresh/{email}/{pass}")
    public ResponseEntity<Object> getToken(@PathVariable("email") String email,
                                           @PathVariable("pass") String pass) {
        ResponseDTO response = ResponseDTO.builder().build();
        UserDTO user = userService.getUserBy(email, pass);
        if (Objects.nonNull(user)) {
            String token = TokenUtil.signToken(email, pass);
            response.setMessage(ConstantUtil.TOKEN_MESSAGE + token);
        }else {
            response.setMessage(ConstantUtil.USER_PASS_NO_VALID);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/verify")
    public ResponseEntity<ResponseDTO> getToken(@RequestHeader(value = "token") String token) {
        ResponseDTO response = ResponseDTO.builder()
            .message(ConstantUtil.TOKEN_VALID)
            .build();
        if(!TokenUtil.verifyToken(token)) {
            response.setMessage(ConstantUtil.NO_VALID_TOKEN);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
     return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
