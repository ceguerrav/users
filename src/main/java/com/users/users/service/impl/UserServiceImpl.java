package com.users.users.service.impl;

import com.users.users.dto.UserDTO;
import com.users.users.repository.UserRepository;
import com.users.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public void createUser(UserDTO user) {

    }
}
