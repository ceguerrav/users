package com.users.users.repository;


import com.users.users.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//@NoRepositoryBean
@Repository
public interface UserRepository
        // extends JpaRepository<User, Integer> , JpaSpecificationExecutor<User> {
        extends CrudRepository<User, Integer> {
    //Optional<User> findById(Integer id);
    //User save(User user);

}
