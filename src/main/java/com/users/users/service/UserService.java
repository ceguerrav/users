package com.users.users.service;

import com.users.users.dto.UserDTO;
import com.users.users.exception.UserException;

public interface UserService  {

    UserDTO createUser(UserDTO userDTO) throws UserException;
}
