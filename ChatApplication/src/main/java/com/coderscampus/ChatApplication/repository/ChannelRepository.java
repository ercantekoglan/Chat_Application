package com.coderscampus.ChatApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.ChatApplication.domain.Channel;


@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long>{
	

	Channel findByChannelId(Long channelId);
}
