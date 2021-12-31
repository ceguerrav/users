package com.users.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    private Integer id;
    private String number;
    private String cityCode;
    private String countryCode;
}

