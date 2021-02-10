package lingar.poc.springbootmongostodos.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/ws")
//http://localhost:8080/ws/test-service
public class WebServices {
	@RequestMapping(value = "/test-service", method = RequestMethod.GET)//this make it not working
//	@RequestMapping("/test-service")
	public String testServer() {
		return "Server is Online";
	}
	
}