package com.users.users.controller;


import com.users.users.dto.ResponseDTO;
import com.users.users.dto.UserDTO;
import com.users.users.exception.UserException;
import com.users.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
@Validated
public class UserController {


    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDTO userDTO)  {
        Object result;
        try {
            result = userService.createUser(userDTO);
        } catch (UserException e) {

            log.error(e.getMessage());
            result = ResponseDTO.builder().message(e.getMessage()).build();

        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
