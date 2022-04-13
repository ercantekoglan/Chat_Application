package com.coderscampus.ChatApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.ChatApplication.domain.User;
import com.coderscampus.ChatApplication.repository.UserRepository;



@Service
public class UserService {
	

	@Autowired
	private UserRepository userRepository;

	public User newUser(String displayName) {
        User user = new User();
        user.setUsername(displayName);
        return userRepository.save(user);
    }

	public User findByUserId(Long userId) {
		return userRepository.findByUserId(userId);
	}

	public List<User> findAll() {
		List<User> findAll = userRepository.findAll();
		return findAll;
	}
	
	

}