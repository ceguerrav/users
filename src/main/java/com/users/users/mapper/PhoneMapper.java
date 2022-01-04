package com.users.users.mapper;

import com.users.users.dto.PhoneDTO;
import com.users.users.dto.UserDTO;
import com.users.users.model.Phone;
import com.users.users.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class PhoneMapper {

    public static final PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);


    public abstract PhoneDTO modelToDTO(Phone phone);
    public abstract Phone dtoToModel(PhoneDTO phoneDTO);

    public abstract UserDTO modelToDTO(User user);
    public abstract User dtoToModel(UserDTO userDTO);
}
