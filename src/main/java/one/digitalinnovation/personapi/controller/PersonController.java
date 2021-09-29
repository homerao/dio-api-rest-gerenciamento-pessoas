package one.digitalinnovation.personapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.model.Person;
import one.digitalinnovation.personapi.service.PersonService;

@RestController
@RequestMapping(path = "/api/v1/person")
public class PersonController {
	
	private PersonService service;
	@Autowired
	public PersonController(PersonService service) {
		this.service = service;
	}
	
	@GetMapping
	public String allPerson() {
		List<Person> p = new ArrayList<>();
		p = service.findAll();
		return p.toString();
	}
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	
	public String createPerson(@RequestBody @Valid PersonDTO personDTO) {
		System.out.println("\n\n\n\n");
		System.out.println(personDTO);
		System.out.println("\n\n\n\n");
		
	 String resposta =   service.createPerson(personDTO);	
		return resposta;
	}
  
}
