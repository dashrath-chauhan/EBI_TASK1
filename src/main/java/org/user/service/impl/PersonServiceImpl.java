package org.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.ResourceNotFoundException;
import org.user.model.Person;
import org.user.repository.PersonRepository;
import org.user.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> addPerson(List<Person> persons) {
		List<Person> newPersons = new ArrayList<Person>();
		
		for(Person person: persons) {
			validatePerson(person);
			
			Person newPerson = new Person();
			
			newPerson.setFirst_name(person.getFirst_name());
			newPerson.setLast_name(person.getLast_name());
			newPerson.setAge(person.getAge());
			newPerson.setFavourite_colour(person.getFavourite_colour());
			
			newPersons.add(newPerson);
		}
		
		return personRepository.save(newPersons);
	}

	@Override
	public List<Person> updatePerson(List<Person> persons) {
		List<Person> newPersons = new ArrayList<Person>();
		
		for(Person person: persons) {
			validatePerson(person);
			
			Person oldPerson = validateAndReturnPerson(person);
			
			oldPerson.setFirst_name(person.getFirst_name());
			oldPerson.setLast_name(person.getLast_name());
			oldPerson.setAge(person.getAge());
			oldPerson.setFavourite_colour(person.getFavourite_colour());
			
			newPersons.add(oldPerson);
		}
		
		return personRepository.save(newPersons);
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person getPerson(Integer personId) {
		Person person = personRepository.findOne(personId);
		
		if(person == null) {
			throw new ResourceNotFoundException("No person found for Id: "+personId);
		}
		
		return person;
	}

	@Override
	public String deletePerson(Integer personId) {
		Person person = personRepository.findOne(personId);
		
		if(person == null) {
			throw new ResourceNotFoundException("No person found for Id: "+personId);
		}
		
		personRepository.delete(person);
		return "Person deleted with id: "+personId;
	}
	
	private void validatePerson(Person person) {
		if(person.getFirst_name() == null) {
			throw new IllegalArgumentException("Firstname cannot be blank");
		}
		
		if(person.getLast_name() == null) {
			throw new IllegalArgumentException("Lastname cannot be blank");
		}
		
		if(person.getAge() == null) {
			throw new IllegalArgumentException("Age cannot be blank");
		}
		
		if(person.getFavourite_colour() == null) {
			throw new IllegalArgumentException("Color cannot be blank");
		}
	}
	
	private Person validateAndReturnPerson(Person person) {
		Person oldPerson = personRepository.findOne(person.getId());
		
		if(oldPerson == null) {
			throw new ResourceNotFoundException("No person found for Id: "+person.getId());
		}
		
		return oldPerson;
	}
}

























