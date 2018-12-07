package com.gleb.springbootdemoaug18.dao;

import com.gleb.springbootdemoaug18.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
