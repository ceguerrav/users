package com.users.users.controller;


import com.users.users.dto.ResponseDTO;
import com.users.users.dto.UserDTO;
import com.users.users.exception.EmailException;
import com.users.users.exception.PasswordException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO)  {
        Object result;
        try {
            result = userService.createUser(userDTO);
        } catch (UserException | PasswordException | EmailException e) {
            log.error(e.getMessage());
            result = ResponseDTO.builder().message(e.getMessage()).build();
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception ex) {
            log.error(ex.getMessage());
            result = ResponseDTO.builder().message(ConstantUtil.ERROR_MESSAGE + ex.getMessage()).build();
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers(@RequestHeader(value = "token") String token) {
        if(!TokenUtil.verifyToken(token)) {
            ResponseDTO response = ResponseDTO.builder().message(ConstantUtil.NO_VALID_TOKEN).build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<UserDTO> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Object> getUser(@RequestParam(name = "email") String email,
                                           @RequestHeader(value = "token") String token) {
        if(!TokenUtil.verifyToken(token)) {
            ResponseDTO response = ResponseDTO.builder().message(ConstantUtil.NO_VALID_TOKEN).build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        UserDTO user = userService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
