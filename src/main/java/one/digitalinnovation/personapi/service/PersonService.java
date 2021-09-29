package one.digitalinnovation.personapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.model.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
@Service
public class PersonService {

	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	private PersonRepository repository;
	@Autowired
	public PersonService(PersonRepository repository) {
		this.repository = repository;
	}
	
	public String createPerson(PersonDTO personDTO) {
		Person p = personMapper.toModel(personDTO);
		repository.save(p);
		return "criado";
	}
	public String updatePerson(PersonDTO personDTO) {
		Person p = personMapper.toModel(personDTO);
		return repository.save(p).toString();
		
	}
	
	public List<PersonDTO> findAll() {
		List<Person> listPerson = new ArrayList<>();
		listPerson = repository.findAll();
		return listPerson.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
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
