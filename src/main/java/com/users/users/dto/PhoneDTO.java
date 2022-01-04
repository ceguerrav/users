package com.users.users.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {

    private Integer id;
    private String number;
    @JsonValue
    private String cityCode;
    @JsonValue
    private String countryCode;

    private  UserDTO user;
}

