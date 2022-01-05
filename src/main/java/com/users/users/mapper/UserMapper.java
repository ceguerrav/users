package com.users.users.mapper;

import com.users.users.dto.UserDTO;
import com.users.users.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserDTO modelToDTO(User user);
    public abstract User dtoToModel(UserDTO userDTO);
}
