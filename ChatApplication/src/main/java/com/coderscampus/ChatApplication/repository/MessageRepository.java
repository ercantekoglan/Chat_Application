package com.coderscampus.ChatApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.ChatApplication.domain.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	@Query(value ="SELECT * FROM MESSAGES WHERE channel_Id = ?", nativeQuery = true)
	List<Message> findAllByChannelId(Long channelId);
}
