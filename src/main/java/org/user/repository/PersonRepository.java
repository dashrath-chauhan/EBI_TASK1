package org.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.user.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	public Optional<Person> findById(Integer id);
}
