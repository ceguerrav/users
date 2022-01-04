package com.users.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PHONE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue
    private Integer id;
    //@Column(name = "number")
    private String number;
    //@Column(name = "city_code")
    private String cityCode;
    //@Column(name = "country_code")
    private String countryCode;

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

