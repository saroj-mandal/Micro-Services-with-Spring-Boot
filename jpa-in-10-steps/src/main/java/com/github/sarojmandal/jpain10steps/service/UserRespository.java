package com.github.sarojmandal.jpain10steps.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.sarojmandal.jpain10steps.bean.User;

public interface UserRespository extends JpaRepository<User, Long> {

}
