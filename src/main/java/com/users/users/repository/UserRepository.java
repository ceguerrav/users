package com.users.users.repository;


import com.users.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository
         extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    List<User> findAll();
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}

