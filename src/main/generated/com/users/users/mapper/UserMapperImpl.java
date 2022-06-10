package com.users.users.mapper;

import com.users.users.dto.PhoneDTO;
import com.users.users.dto.UserDTO;
import com.users.users.dto.UserDTO.UserDTOBuilder;
import com.users.users.model.Phone;
import com.users.users.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-09T23:24:28-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class UserMapperImpl extends UserMapper {

    @Override
    public UserDTO modelToDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( user.getId() );
        userDTO.name( user.getName() );
        userDTO.email( user.getEmail() );
        userDTO.password( user.getPassword() );
        userDTO.token( user.getToken() );
        userDTO.created( user.getCreated() );
        userDTO.modified( user.getModified() );
        userDTO.lastLogin( user.getLastLogin() );
        userDTO.isActive( user.getIsActive() );
        userDTO.phones( phoneListToPhoneDTOList( user.getPhones() ) );

        return userDTO.build();
    }

    @Override
    public List<UserDTO> modelListToDTOList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userList.size() );
        for ( User user : userList ) {
            list.add( modelToDTO( user ) );
        }

        return list;
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
        user.setPhones( phoneDTOListToPhoneList( userDTO.getPhones() ) );

        return user;
    }

    @Override
    public Phone dtoToModel(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setId( phoneDTO.getId() );
        phone.setNumber( phoneDTO.getNumber() );
        phone.setCityCode( phoneDTO.getCityCode() );
        phone.setCountryCode( phoneDTO.getCountryCode() );

        return phone;
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

        return phoneDTO;
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }

    protected List<Phone> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( dtoToModel( phoneDTO ) );
        }

        return list1;
    }
}
