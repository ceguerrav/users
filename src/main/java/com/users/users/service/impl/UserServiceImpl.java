package com.users.users.service.impl;

import com.users.users.dto.UserDTO;
import com.users.users.exception.EmailException;
import com.users.users.exception.PasswordException;
import com.users.users.exception.UserException;
import com.users.users.mapper.UserMapper;
import com.users.users.model.User;
import com.users.users.repository.UserRepository;
import com.users.users.service.UserService;
import com.users.users.utils.ConstantUtil;
import com.users.users.utils.TokenUtil;
import com.users.users.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;



    @Override
    public UserDTO getUserByEmail(String email){
        Objects.requireNonNull(email, ConstantUtil.EMAIL_REQUIRED);
        User user = userRepository.findByEmail(email);
        return UserMapper.INSTANCE.modelToDTO(user);
    }
    @Override
    public List<UserDTO> getAllUsers() {
        List<User> all = userRepository.findAll();
        return Optional.ofNullable(UserMapper.INSTANCE.modelListToDTOList(all))
            .orElse(new ArrayList<>());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) throws UserException, EmailException, PasswordException {

        ValidationUtil.validateUserDTO(userDTO);

        User user = UserMapper.INSTANCE.dtoToModel(userDTO);
        String token = "";
        try {
            token = getToken(user.getEmail(), user.getPassword());
            user.setCreated(LocalDateTime.now());
            user.setModified(LocalDateTime.now());
            user.setLastLogin(LocalDateTime.now());
            user.setIsActive(Boolean.TRUE);
            user.setToken(token);
            user = userRepository.save(user);

        } catch (DataIntegrityViolationException er) {
            log.error("Email ya existe: {}", user.getEmail());
            throw new UserException("Email ya existe: "+ userDTO.getEmail());
        } catch (Exception ex) {
            throw new UserException("Error: "+ ex.getMessage());
        }
        return UserMapper.INSTANCE.modelToDTO(user);
    }

    private String getToken(String email, String pass) {
        return TokenUtil.signToken(email,pass);
    }

}
