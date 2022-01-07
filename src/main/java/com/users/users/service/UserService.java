package com.users.users.service;

import com.users.users.dto.UserDTO;
import com.users.users.exception.EmailException;
import com.users.users.exception.PasswordException;
import com.users.users.exception.UserException;

import java.util.List;

public interface UserService  {

    UserDTO getUserBy(String email, String pass);

    UserDTO getUserByEmail(String email);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO) throws UserException, EmailException, PasswordException;
}
