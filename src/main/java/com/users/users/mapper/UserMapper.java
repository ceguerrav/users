package com.users.users.mapper;

import com.users.users.dto.PhoneDTO;
import com.users.users.dto.UserDTO;
import com.users.users.model.Phone;
import com.users.users.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserDTO modelToDTO(User user);
    public abstract List<UserDTO> modelListToDTOList(List<User> userList);

    public abstract User dtoToModel(UserDTO userDTO);
    @Mapping(ignore = true, target = "user")
    public abstract Phone dtoToModel(PhoneDTO phoneDTO);
}
