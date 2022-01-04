package com.users.users.mapper;

import com.users.users.dto.PhoneDTO;
import com.users.users.model.Phone;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-04T20:27:14-0300",
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

        return phone;
    }
}
