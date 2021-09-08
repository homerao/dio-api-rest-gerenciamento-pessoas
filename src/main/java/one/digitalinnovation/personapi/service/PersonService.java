package one.digitalinnovation.personapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.personapi.model.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
@Service
public class PersonService {

	
	private PersonRepository repository;
	@Autowired
	public PersonService(PersonRepository repository) {
		this.repository = repository;
	}
	
	public String createPerson(Person p) {
		repository.save(p);
		return "criado";
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}
}
