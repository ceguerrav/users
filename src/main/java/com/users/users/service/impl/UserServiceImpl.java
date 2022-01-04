package com.users.users.service.impl;

import com.users.users.dto.UserDTO;
import com.users.users.exception.UserException;
import com.users.users.mapper.UserMapper;
import com.users.users.model.User;
import com.users.users.repository.UserRepository;
import com.users.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) throws UserException {

        User user = UserMapper.INSTANCE.dtoToModel(userDTO);
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setIsActive(Boolean.TRUE);

        user = Optional.ofNullable(userRepository.save(user))
            .orElseThrow(() -> new UserException("Ha ocurrido un error :("));

        UserDTO result = UserMapper.INSTANCE.modelToDTO(user);
        return result;
    }
}
