package com.users.users.controller;


import com.users.users.dto.ResponseDTO;
import com.users.users.dto.UserDTO;
import com.users.users.exception.EmailException;
import com.users.users.exception.PasswordException;
import com.users.users.exception.UserException;
import com.users.users.service.UserService;
import com.users.users.utils.ConstantUtil;
import com.users.users.utils.ResponseUtil;
import com.users.users.utils.TokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
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

        try {
            return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
        } catch (EmailException e) {
            log.error(e.getMessage());
            return ResponseUtil.buildResponse(e.getMessage(), HttpStatus.CONFLICT);
        } catch (PasswordException e) {
            log.error(e.getMessage());
            return ResponseUtil.buildResponse(e.getMessage(), HttpStatus.UNAUTHORIZED);
        } catch (UserException e) {
            log.error(e.getMessage());
            return ResponseUtil.buildResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseUtil.buildResponse(ConstantUtil.ERROR_MESSAGE + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers(@RequestHeader(value = "token") String token) {
        ResponseDTO result = ResponseDTO.builder().build();
        List<UserDTO> allUsers;
        try {
            if(!TokenUtil.verifyToken(token)) {
                return ResponseUtil.buildResponse(ConstantUtil.NO_VALID_TOKEN, HttpStatus.UNAUTHORIZED);
            }
            allUsers = userService.getAllUsers();
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        } catch (UserException e) {
            log.error(e.getMessage());
            return ResponseUtil.buildResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            result.setMessage(ConstantUtil.ERROR_MESSAGE + ex.getMessage());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{email}")
    public ResponseEntity<Object> getUser(@PathVariable(name = "email") String email,
                                          @RequestHeader(value = "token") String token) {
        UserDTO user;
        try {
            if(!TokenUtil.verifyToken(token)) {
                return ResponseUtil.buildResponse(ConstantUtil.NO_VALID_TOKEN, HttpStatus.UNAUTHORIZED);
            }
            user = userService.getUserByEmail(email);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserException e) {
            log.error(e.getMessage());
            return ResponseUtil.buildResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseUtil.buildResponse(ConstantUtil.ERROR_MESSAGE + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
