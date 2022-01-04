package com.users.users.mapper;

import com.users.users.dto.UserDTO;
import com.users.users.model.User;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-04T20:27:14-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
public class UserMapperImpl extends UserMapper {

    @Override
    public UserDTO modelToDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setToken( user.getToken() );
        userDTO.setCreated( user.getCreated() );
        userDTO.setModified( user.getModified() );
        userDTO.setLastLogin( user.getLastLogin() );
        userDTO.setIsActive( user.getIsActive() );

        return userDTO;
    }

    @Override
    public User dtoToModel(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setName( userDTO.getName() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );
        user.setToken( userDTO.getToken() );
        user.setCreated( userDTO.getCreated() );
        user.setModified( userDTO.getModified() );
        user.setLastLogin( userDTO.getLastLogin() );
        user.setIsActive( userDTO.getIsActive() );

        return user;
    }
}
