package com.user.register.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.register.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
