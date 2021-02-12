package org.user.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.user.model.Person;
import org.user.service.PersonService;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;

	@GetMapping("/persons")
    public List<Person> getAllPersons() {
		logger.info("Retrieving all persons.");
        return personService.getAllPersons();
    }

    @GetMapping("/person/{personId}")
    public Person getPerson(@PathVariable Integer personId) {
    	logger.info("Retrieving person with Id: ",personId);
        return personService.getPerson(personId);
    }

    @PostMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED) 
    public List<Person> addPerson(@RequestBody List<Person> persons) {
    	logger.info("Adding new persons.");
    	return personService.addPerson(persons);
    }

    @PutMapping("/persons")
    public List<Person> updatePerson(@RequestBody List<Person> persons) {
    	logger.info("Updating persons.");
    	return personService.updatePerson(persons);
    }

    @DeleteMapping("/person/{personId}")
    public String deletePerson(@PathVariable Integer personId) {
    	personService.deletePerson(personId);
    	return "Person deleted with id: "+personId;
    }
}
