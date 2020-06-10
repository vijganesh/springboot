package com.microservices.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.config.DbSettings;

@RestController
public class GreetingController {
	@Value("${my.greeting}")
	private String greetingMessage;
	
	@Value("Somoe static message")
	private String staticMessage;
	
	@Value("${my.list.values}")
	private List<String> listValues;
	
	/*@Value("#{${dbValues}}")
	private Map<String,String> dbValues;*/
	
	@Autowired
	private DbSettings dbSettings;
	
	@RequestMapping("/greetings")
	public String greeting() {
		//return greetingMessage+" "+staticMessage+" "+listValues+" "+dbValues;
		return dbSettings.getConnection()+","+dbSettings.getHost();
	}
}
