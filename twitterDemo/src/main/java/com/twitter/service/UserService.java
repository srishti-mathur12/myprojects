package com.twitter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.twitter.dao.UserRepository;
import com.twitter.entity.*;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public List<User> getAllUser() {
		List<User> usersList = new ArrayList<>();
		try {

			usersList = userRepository.findAll();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return usersList;
	}

	public void save(User user) {
		userRepository.save(user);
	}

}
