package com.users.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue
    private Integer id;
    //@Column(name = "name")
    private String name;
    //@Column(name = "email")
    private String email;
    //@Column(name = "password")
    private String password;
    //@Column(name = "token")
    private String token;
    //@Column(name = "created")
    private LocalDateTime created;
    //@Column(name = "modified")
    private LocalDateTime modified;
    //@Column(name = "last_login")
    private LocalDateTime lastLogin;
    //@Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones;

}
