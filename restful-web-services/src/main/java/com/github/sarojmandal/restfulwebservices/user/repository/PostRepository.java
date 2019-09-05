package com.github.sarojmandal.restfulwebservices.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.sarojmandal.restfulwebservices.user.bean.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
