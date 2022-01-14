package com.users.users.service.impl;


import com.users.users.dto.UserDTO;
import com.users.users.exception.EmailException;
import com.users.users.exception.PasswordException;
import com.users.users.exception.UserException;
import com.users.users.mapper.UserMapper;
import com.users.users.model.User;
import com.users.users.repository.UserRepository;
import com.users.users.service.UserService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

class UserServiceImplUnitTest {

    @Mock
    private UserRepository userRepository;
    private final EasyRandom easyRandom = new EasyRandom();
    private UserService userService;
    private final UserDTO userDTO = easyRandom.nextObject(UserDTO.class);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository);
        userDTO.setEmail("lala@lala.com");
        userDTO.setPassword("Hhh12");
    }

    @Test
    void createUserWhenIsOK() throws UserException, EmailException, PasswordException {
        User model = UserMapper.INSTANCE.dtoToModel(userDTO);

        Mockito.when(userRepository.save(any())).thenReturn(model);
        UserDTO user = userService.createUser(userDTO);
        assertThat(user).isNotNull();

    }


    @Test
    void createUserWhenAlreadyExists() {
        Mockito.when(userRepository.save(any()))
            .thenThrow(DataIntegrityViolationException.class);

        assertThrows(UserException.class, () ->
                userService.createUser(userDTO),
            "Email ya existe: " + userDTO.getEmail());
    }



    @Test
    void getAllUsers() {
        UserDTO userDTO1 = easyRandom.nextObject(UserDTO.class);
        User model1 = UserMapper.INSTANCE.dtoToModel(userDTO1);
        UserDTO userDTO2 = easyRandom.nextObject(UserDTO.class);
        User model2 = UserMapper.INSTANCE.dtoToModel(userDTO2);
        List<User> users = new ArrayList<>(Arrays.asList(model1, model2));

        Mockito.when(userRepository.findAll()).thenReturn(users);
        List<UserDTO> allUsers = userService.getAllUsers();
        assertThat(allUsers).isNotNull();

    }

    @Test
    void getUser() {
        UserDTO userDTO1 = easyRandom.nextObject(UserDTO.class);
        User model1 = UserMapper.INSTANCE.dtoToModel(userDTO1);

        Mockito.when(userRepository.findByEmail(anyString())).thenReturn(model1);
        UserDTO response = userService.getUserByEmail(model1.getEmail());
        assertThat(response).isNotNull();

    }

    @Test
    void getUserBy() {
        UserDTO userDTO1 = easyRandom.nextObject(UserDTO.class);
        User model1 = UserMapper.INSTANCE.dtoToModel(userDTO1);

        Mockito.when(userRepository.findByEmailAndPassword(anyString(), anyString()))
            .thenReturn(model1);
        UserDTO response = userService.getUserBy(model1.getEmail(), model1.getPassword());
        assertThat(response).isNotNull();

    }
}
