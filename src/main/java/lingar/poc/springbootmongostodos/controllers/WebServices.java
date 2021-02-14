package lingar.poc.springbootmongostodos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/test-service", method = RequestMethod.GET) // this make it not working
	public String testServer() {
		return "Server is Online";
	}

	// http://localhost:8080/ws/getTodos
	@RequestMapping(value = "/todoAction")
	public List<Todo> getTodos() {
		return repository.findAll();
	}

	// http://localhost:8080/ws/getTodo/PUT_HERE_ONE_OF_UPDATED_IDS(SEE LOGS)
	@RequestMapping(value = "/todoAction/{id}")
	public Todo getTodo(@PathVariable(value = "id") String id) {
		return repository.findById(id).get();
	}

	//You can check this method with postman. 
	@RequestMapping(value = "/todoAction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Todo createTodo(@RequestBody Todo newItem) {
		try {
			repository.save(newItem);
			return newItem;

		} catch (Exception e) {
			//handle exception
			System.err.println("error occurred :" + e.getMessage());
			return null;
		}

	}

	//You can check this method with postman. 
	@RequestMapping(value = "/todoAction", method = RequestMethod.PUT, consumes = MediaType.TEXT_PLAIN_VALUE)
	public boolean updateTodo(@RequestBody  String id) {
		try {
			Todo todo = repository.findById(id).get();
			todo.setMark(!todo.isMark());
			repository.save(todo);
			
			return true; 

		} catch (Exception e) {
			// handle exception
			System.err.println("error occurred :" + e.getMessage());
			return false;
		}

	}

}