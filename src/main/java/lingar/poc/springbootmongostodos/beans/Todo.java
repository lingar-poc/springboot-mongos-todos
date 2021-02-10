package lingar.poc.springbootmongostodos.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection="todos")
public class Todo {
	
	
	public Todo() {}
	public Todo(String description, boolean marked) {
		this.description = description;
		this.mark = marked;
	}
	@Id
	public String id;
	
	public String description;
	public boolean mark;

}