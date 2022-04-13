package com.coderscampus.ChatApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.ChatApplication.domain.Channel;
import com.coderscampus.ChatApplication.repository.ChannelRepository;



@Service
public class ChannelService {
	
	@Autowired
	private ChannelRepository channelRepo;

	
	public List<Channel> findChannels() {
		List<Channel> findAll = channelRepo.findAll();
		if(findAll.size() == 0) {
			
			Channel generalChannel = new Channel();
			generalChannel.setName("General");
			
			Channel educationChannel = new Channel();
			educationChannel.setName("Education");
			
			Channel sporChannel = new Channel();
			sporChannel.setName("Sport");
			
			Channel policsChannel = new Channel();
			policsChannel.setName("Politics");
			
			findAll.add(generalChannel);
			findAll.add(educationChannel);
			findAll.add(sporChannel);
			findAll.add(policsChannel);
			
			channelRepo.save(generalChannel);
			channelRepo.save(educationChannel);
			channelRepo.save(sporChannel);
			channelRepo.save(policsChannel);
			
		}
		return findAll;
	}


	public Channel createChannel(String channelName) {

		Channel newChannel= new Channel();
		newChannel.setName(channelName);

		return channelRepo.save(newChannel);
	}


	public Channel findById(Long channelId) {
		return channelRepo.findByChannelId(channelId);
	}

}