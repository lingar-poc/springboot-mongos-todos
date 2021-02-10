package lingar.poc.springbootmongostodos.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import lingar.poc.springbootmongostodos.beans.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> {

//  public Todo findByFirstName(String firstName);
  public List<Todo> findByMark(boolean mark);

}