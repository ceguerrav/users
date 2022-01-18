package com.users.users.controller;


import com.users.users.dto.ResponseDTO;
import com.users.users.dto.TokenDTO;
import com.users.users.dto.UserDTO;
import com.users.users.exception.UserException;
import com.users.users.service.UserService;
import com.users.users.utils.ConstantUtil;
import com.users.users.utils.TokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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



    @PostMapping("/refresh")
    public ResponseEntity<Object> getToken(@RequestBody TokenDTO tokenDTO) throws UserException {
        ResponseDTO response = ResponseDTO.builder().build();
        UserDTO user = userService.getUserBy(tokenDTO.getEmail(), tokenDTO.getPassword());
        if (Objects.nonNull(user)) {
            String token = TokenUtil.signToken(tokenDTO.getEmail());
            response.setMessage(ConstantUtil.TOKEN_MESSAGE + token);
        }else {
            response.setMessage(ConstantUtil.USER_PASS_NO_VALID);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/verify")
    public ResponseEntity<ResponseDTO> getToken(@RequestHeader(value = "token") String token) {
        ResponseDTO response = ResponseDTO.builder()
            .message(ConstantUtil.TOKEN_VALID)
            .build();
        if(!TokenUtil.verifyToken(token)) {
            response.setMessage(ConstantUtil.NO_VALID_TOKEN);
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
     return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
