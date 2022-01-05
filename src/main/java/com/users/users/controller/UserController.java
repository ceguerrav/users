package com.users.users.controller;


import com.users.users.dto.UserDTO;
import com.users.users.exception.UserException;
import com.users.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
@Validated
public class UserController {


    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) throws UserException {
        UserDTO result = userService.createUser(userDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
