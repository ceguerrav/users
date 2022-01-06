package com.users.users.service.impl;

import com.users.users.dto.UserDTO;
import com.users.users.exception.UserException;
import com.users.users.mapper.UserMapper;
import com.users.users.model.User;
import com.users.users.repository.UserRepository;
import com.users.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) throws UserException {

        User user = UserMapper.INSTANCE.dtoToModel(userDTO);


        try {
            user.setCreated(LocalDateTime.now());
            user.setModified(LocalDateTime.now());
            user.setLastLogin(LocalDateTime.now());
            user.setIsActive(Boolean.TRUE);
            user = userRepository.save(user);

        } catch (DataIntegrityViolationException er) {
            log.error("Email ya existe: {}", user.getEmail());
            throw new UserException("Email ya existe: "+ user.getEmail());
        } catch (Exception ex) {
            throw new UserException("Error: "+ ex.getMessage());
        }
        return UserMapper.INSTANCE.modelToDTO(user);
    }
}
