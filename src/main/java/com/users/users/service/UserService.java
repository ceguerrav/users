package com.users.users.service;

import com.users.users.dto.UserDTO;
import com.users.users.exception.EmailException;
import com.users.users.exception.UserException;

import java.util.List;

public interface UserService  {

    List<UserDTO> getAllUsers(String email);

    UserDTO createUser(UserDTO userDTO) throws UserException, EmailException;
}
