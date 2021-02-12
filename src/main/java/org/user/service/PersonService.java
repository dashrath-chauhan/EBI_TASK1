package org.user.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.user.model.Person;

public interface PersonService {
	
	public List<Person> addPerson(@NotNull List<Person> persons);
	
	public List<Person> updatePerson(@NotNull List<Person> persons);
	
	public List<Person> getAllPersons();
	
	public Person getPerson(@NotNull Integer personId);
	
	public String deletePerson(@NotNull Integer personId);
}
