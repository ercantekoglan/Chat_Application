package com.coderscampus.ChatApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.ChatApplication.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserId(Long userId);

	User findByUsername(String user);

}
