package com.twitter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twitter.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
