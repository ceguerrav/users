package com.users.users.mapper;

import com.users.users.dto.PhoneDTO;
import com.users.users.dto.UserDTO;
import com.users.users.model.Phone;
import com.users.users.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-04T18:33:29-0300",
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
        userDTO.setPhones( modelListToDTOList( user.getPhones() ) );

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
        user.setPhones( dtoListToModelList( userDTO.getPhones() ) );

        return user;
    }

    @Override
    public List<PhoneDTO> modelListToDTOList(List<Phone> phone) {
        if ( phone == null ) {
            return null;
        }

        List<PhoneDTO> list = new ArrayList<PhoneDTO>( phone.size() );
        for ( Phone phone1 : phone ) {
            list.add( phoneToPhoneDTO( phone1 ) );
        }

        return list;
    }

    @Override
    public List<Phone> dtoListToModelList(List<PhoneDTO> phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        List<Phone> list = new ArrayList<Phone>( phoneDTO.size() );
        for ( PhoneDTO phoneDTO1 : phoneDTO ) {
            list.add( phoneDTOToPhone( phoneDTO1 ) );
        }

        return list;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setId( phone.getId() );
        phoneDTO.setNumber( phone.getNumber() );
        phoneDTO.setCityCode( phone.getCityCode() );
        phoneDTO.setCountryCode( phone.getCountryCode() );
        phoneDTO.setUser( modelToDTO( phone.getUser() ) );

        return phoneDTO;
    }

    protected Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setId( phoneDTO.getId() );
        phone.setNumber( phoneDTO.getNumber() );
        phone.setCityCode( phoneDTO.getCityCode() );
        phone.setCountryCode( phoneDTO.getCountryCode() );
        phone.setUser( dtoToModel( phoneDTO.getUser() ) );

        return phone;
    }
}
