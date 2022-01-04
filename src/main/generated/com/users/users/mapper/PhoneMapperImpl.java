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
public class PhoneMapperImpl extends PhoneMapper {

    @Override
    public PhoneDTO modelToDTO(Phone phone) {
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
        phone.setUser( dtoToModel( phoneDTO.getUser() ) );

        return phone;
    }

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
        userDTO.setPhones( phoneListToPhoneDTOList( user.getPhones() ) );

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
        user.setPhones( phoneDTOListToPhoneList( userDTO.getPhones() ) );

        return user;
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( modelToDTO( phone ) );
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
