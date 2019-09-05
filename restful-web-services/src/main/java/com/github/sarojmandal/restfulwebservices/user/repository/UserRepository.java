package com.github.sarojmandal.restfulwebservices.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.sarojmandal.restfulwebservices.user.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
