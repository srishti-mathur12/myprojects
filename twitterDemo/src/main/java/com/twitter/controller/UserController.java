package com.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.twitter.entity.*;
import com.twitter.service.UserService;
import java.util.*;

@RestController
public class UserController {

	@Autowired
	public UserService userService;

	@RequestMapping(value="/users",method = RequestMethod.GET)
	public List<User> getAllUser() {
		return userService.getAllUser();

	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		userService.save(user);
	}

}
