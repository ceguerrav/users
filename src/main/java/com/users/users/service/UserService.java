package com.users.users.service;

import com.users.users.dto.UserDTO;
import com.users.users.exception.EmailException;
import com.users.users.exception.PasswordException;
import com.users.users.exception.UserException;

import java.util.List;

public interface UserService  {

    UserDTO getUserBy(String email, String pass) throws UserException;

    UserDTO getUserByEmail(String email) throws UserException;

    List<UserDTO> getAllUsers() throws UserException;

    UserDTO createUser(UserDTO userDTO) throws UserException, EmailException, PasswordException;
}
