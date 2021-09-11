package one.digitalinnovation.personapi.service;

import java.util.List;

import javax.persistence.PersistenceException;

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
	public String updatePerson(Person p) {
		return repository.save(p).toString();
		
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}
	public Person findOne(String cpf) {
		return repository.findByCpf(cpf);
		
	}
	public Person findOne(Long id) {
		Person p = null;
		if(repository.findById(id).isPresent()) {
			p = repository.findById(id).get();
			return p;
		} else {
			throw new PersistenceException("Este Id não existe na base de dados");
		}
		
	}
}
