package com.ebl.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebl.model.PersonData;
import com.ebl.model.PersonModel;
import com.ebl.service.PersonDataService;

@RestController
@RequestMapping(value = "/personData")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PersonRestService {

	@Autowired
	private PersonDataService personDataService;
	
	@Autowired
	private PersonData personData;
	
	
	@GetMapping(value="/getAllPerson",produces = {"application/json"})
	public ResponseEntity<PersonData> getGetAllPersonInformation(){
		personData.setPerson(personDataService.getAllPerson());
		return new ResponseEntity<PersonData>(personData, HttpStatus.OK);
	}
	
	@GetMapping(value="/getPersonById/{personId}", produces = {"application/json"})
	public ResponseEntity<PersonData> getPersonById(@PathVariable("personId") Long personId) {
		personData.setPerson(personDataService.getPersonById(personId));
		return new ResponseEntity<PersonData>(personData, HttpStatus.OK);
	}
	@PostMapping(value = "/createPerson",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<PersonModel> createPerson(@RequestBody PersonModel personModel) {
		personDataService.addPerson(personModel);
		return new ResponseEntity<PersonModel>(personModel, HttpStatus.CREATED);
    }
	
	@DeleteMapping(value="/deletePersonById/{personId}", produces = {"application/json"})
	public ResponseEntity<String> deletePerson(@PathVariable("personId") Long personId) {
		personDataService.deletePerson(personId);
		return new ResponseEntity<String>("Person deleted successfully", HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value="/updatePerson", consumes = {"application/json"},
			produces = {"application/json"})
	public ResponseEntity<PersonModel> updatePerson(@RequestBody PersonModel personModel) {
		personDataService.updatePerson(personModel);
		return new ResponseEntity<PersonModel>(personModel, HttpStatus.OK);
	}
}
