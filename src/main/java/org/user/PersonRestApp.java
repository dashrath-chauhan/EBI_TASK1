package org.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.user.model.Person;
import org.user.repository.PersonRepository;

@SpringBootApplication()
public class PersonRestApp {

	public static void main(String[] args) {
		SpringApplication.run(PersonRestApp.class, args);
	}
	
	@Bean
    CommandLineRunner initDatabase(PersonRepository repository) {
        return args -> {
            repository.save(new Person("John", "Doe", 25, "Red"));
            repository.save(new Person("Black", "Smith", 30, "Green"));
        };
    }

}
