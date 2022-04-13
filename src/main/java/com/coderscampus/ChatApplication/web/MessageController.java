package com.coderscampus.ChatApplication.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.ChatApplication.dto.MessageDto;
import com.coderscampus.ChatApplication.service.MessageService;



@Controller
public class MessageController {
	

	@Autowired
	private MessageService messageService;
	
	
	//save message
	@ResponseBody
	@PostMapping("/messageSent/{channelId}")
	private void messageReceived(@RequestBody MessageDto message, @PathVariable Long channelId) {
		MessageDto messageDto = new MessageDto();
		System.out.println(message.getChannelId());
		messageDto.setChannelId(message.getChannelId());
		messageDto.setMessage(message.getMessage());
		messageDto.setUserId(message.getUserId());
		messageService.createMessage(message, channelId);

	}
	//display message
	@ResponseBody
	@PostMapping("/obtainMessages/{channelId}")
		private List<MessageDto> obtainMessages(@PathVariable Long channelId) {
			return messageService.getMessageByChannelId(channelId);
		
	}

}
