package com.users.users.mapper;

import com.users.users.dto.PhoneDTO;
import com.users.users.dto.UserDTO;
import com.users.users.model.Phone;
import com.users.users.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserDTO modelToDTO(User user);
    public abstract User dtoToModel(UserDTO userDTO);

    public abstract List<PhoneDTO> modelListToDTOList(List<Phone> phone);
    public abstract List<Phone> dtoListToModelList(List<PhoneDTO> phoneDTO);


}
