package com.coderscampus.ChatApplication.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.ChatApplication.domain.Channel;
import com.coderscampus.ChatApplication.service.ChannelService;
import com.coderscampus.ChatApplication.service.UserService;



@Controller
public class ChannelController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ChannelService channelService;

	
	// display channels
	@GetMapping("/welcome")
	public String getChannels(ModelMap model) {
		Channel channel = new Channel();
		model.put("channels", channelService.findChannels());
		model.put("channel", channel);
		return "welcome";
	}

	// create new channel
	@PostMapping("/createChannel")
	public String createChannel(Channel channel) {
		if (!(channel.getName().isBlank())) {
			channelService.createChannel(channel.getName());
		}
		return "redirect:/welcome";
	}

	//display channel
	@GetMapping("/channels/{channelId}")
	public String showChannels(ModelMap model, @PathVariable Long channelId) {
		Channel channel = channelService.findById(channelId);
		model.put("channel", channel);
		model.put("users", userService.findAll());
		return "channels";
	}

}