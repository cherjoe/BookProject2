package com.example.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationService 
{

	@Value("host")
	private String host;
	@Value("port")
	private String port;
	@Value("email")
	private String email;
	@Value("password")
	private String password;
	
	
	public NotificationService()
	{
		
	}
	
	public void sendEmail(String sendTo,String subject, String message)
	{
		System.out.println("Email sent");
	}
	
	
	public NotificationService(String host, String port, String email, String password) {
		super();
		this.host = host;
		this.port = port;
		this.email = email;
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
