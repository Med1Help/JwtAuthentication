package com.workshop.BOALI.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
    //String getPassword(String password);

}
