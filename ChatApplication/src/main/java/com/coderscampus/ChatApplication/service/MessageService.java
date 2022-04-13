package com.coderscampus.ChatApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.ChatApplication.domain.Channel;
import com.coderscampus.ChatApplication.domain.Message;
import com.coderscampus.ChatApplication.domain.User;
import com.coderscampus.ChatApplication.dto.MessageDto;
import com.coderscampus.ChatApplication.repository.MessageRepository;



@Service
public class MessageService {
	
	@Autowired
	private ChannelService channelService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageRepository messageRepo;

	public void createMessage(MessageDto message, Long channelId) {
		Channel channel = channelService.findById(channelId);
		Message newMessage = new Message();
		User user = new User();
		user = userService.findByUserId(message.getUserId());
		newMessage.setUser(user);
		newMessage.setMessage(message.getMessage());
		newMessage.setChannel(channel);
		messageRepo.save(newMessage);
		
	}

	public List<MessageDto> getMessageByChannelId(Long channelId) {
		List<Message> messageList = messageRepo.findAllByChannelId(channelId);
		List<MessageDto> messagesDto = new ArrayList<>();
		for (Message message:messageList) {
			MessageDto messageDto = new MessageDto();
			messageDto.setMessage(message.getMessage());
			messageDto.setUserId(message.getUser().getUserId());
			messageDto.setChannelId(message.getMessageId());
			messageDto.setUsername(message.getUser().getUsername());
			messagesDto.add(messageDto);
		}
		return messagesDto;
	}

}