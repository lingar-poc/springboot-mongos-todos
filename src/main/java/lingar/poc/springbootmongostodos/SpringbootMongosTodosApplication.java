package lingar.poc.springbootmongostodos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lingar.poc.springbootmongostodos.beans.Todo;
import lingar.poc.springbootmongostodos.dao.TodoRepository;

/**
 * IF YOU WANT TO SEE IT WORK - Run it with mongo opened - see that the data
 * below has created. And after the sleep the value of the marked get changed.
 * 
 * @author Lingar
 *
 */

@SpringBootApplication
public class SpringbootMongosTodosApplication implements CommandLineRunner {
	@Autowired
	private TodoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongosTodosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		repository.deleteAll();
		Todo t1 = new Todo("go to sleep", false);
		Todo t2 = new Todo("Eat something", false);
		Todo t3 = new Todo("Be happy", false);

		// List 1
		List<Todo> todosList = Arrays.asList(t1, t2, t3);

		// List 2
		ArrayList<Todo> todosArrayList = new ArrayList<>();

		todosArrayList.addAll(todosList);
		//saving all data to the DB. You can check it now 
		repository.saveAll(todosArrayList);
		System.out.println("Todos found with findAll(): -befoe change ");
		System.out.println("-------------------------------");
		for (Todo todo : repository.findAll()) {
			System.out.println(todo);
		}
		System.out.println();
		Thread.sleep(10000);
		t3.setMark(true);//changing one of the items 
		repository.save(t3);//and saving it 
		System.out.println("sleep finished");

		System.out.println("Todos found with findAll(): -after change");
		System.out.println("-------------------------------");
		for (Todo todo : repository.findAll()) {
			System.out.println(todo);
		}
		System.out.println();

		
		System.out.println("Todo found with findByMark(false):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByMark(false));

	}

}
