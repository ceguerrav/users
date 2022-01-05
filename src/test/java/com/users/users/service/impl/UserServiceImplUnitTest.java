package com.users.users.service.impl;


import com.users.users.dto.UserDTO;
import com.users.users.exception.UserException;
import com.users.users.mapper.UserMapper;
import com.users.users.model.User;
import com.users.users.repository.UserRepository;
import com.users.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.jeasy.random.EasyRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

class UserServiceImplUnitTest {

    @Mock
    private UserRepository userRepository;
    //private final EasyRandom easyRandom = new EasyRandom();
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository);
    }
    @Test
    void createUserWhenIsOK() throws UserException {
        UserDTO userDTO = UserDTO.builder().build();
        User model = UserMapper.INSTANCE.dtoToModel(userDTO);

        Mockito.when(userRepository.save(any())).thenReturn(model);
        UserDTO user = userService.createUser(userDTO);
        assertThat(user).isNotNull();

    }

}
