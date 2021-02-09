package lingar.poc.springbootmongostodos.beans;

import org.springframework.data.annotation.Id;

public class Todo {

	@Id
	public String id;

	public String description;
	public boolean marked;

	public Todo() {

	}

}