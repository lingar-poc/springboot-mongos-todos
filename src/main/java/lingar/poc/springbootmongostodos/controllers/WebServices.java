package lingar.poc.springbootmongostodos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lingar.poc.springbootmongostodos.beans.Todo;
import lingar.poc.springbootmongostodos.dao.TodoRepository;

@RestController
@CrossOrigin
@RequestMapping("/ws")
//http://localhost:8080/ws/test-server
public class WebServices {
	@Autowired
	private TodoRepository repository;

	@RequestMapping(value = "/test-service", method = RequestMethod.GET)//this make it not working
	public String testServer() {
		return "Server is Online";
	}
	
	//http://localhost:8080/ws/getTodos
	@RequestMapping(value = "/getTodos")
	public List<Todo> getTodos(){
		return repository.findAll();
	}
	
	
	
}