package lingar.poc.springbootmongostodos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringbootMongosTodosApplication.class)
//if You have problem with this annotation this is the solution
//https://stackoverflow.com/a/47019765/9727918
class SpringbootMongosTodosApplicationTests {

	@Test
	void contextLoads() {
	}

}
