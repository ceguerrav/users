package com.users.users.mapper;

import com.users.users.dto.PhoneDTO;
import com.users.users.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class PhoneMapper {

    public static final PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);


    public abstract PhoneDTO modelToDTO(Phone phone);
    //@Mapping(ignore = true, target = "user")
    public abstract Phone dtoToModel(PhoneDTO phoneDTO);


}
