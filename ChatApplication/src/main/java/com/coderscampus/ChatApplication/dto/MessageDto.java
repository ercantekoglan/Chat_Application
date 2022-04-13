package com.coderscampus.ChatApplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {
	
	@JsonProperty("message")
	private String message;
	@JsonProperty("userId")
	private Long userId;
	@JsonProperty("channelId")
	private Long channelId;
	@JsonProperty("username")
	private String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}	
	
}
