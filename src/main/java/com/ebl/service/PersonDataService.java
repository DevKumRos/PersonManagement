package com.ebl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebl.entity.Hobby;
import com.ebl.entity.Person;
import com.ebl.exception.RecordNotFoundException;
import com.ebl.model.PersonModel;
import com.ebl.repository.PersonRepository;
@Component
public class PersonDataService {

	@Autowired
	private PersonRepository personRepository;
	
	
	public void addPerson(PersonModel personModel) {
		Person person = convertPersonModelToPerson(personModel);
		person = personRepository.saveAndFlush(person);
		personModel.setPersonId(person.getId());
	}
	
	public List<PersonModel> getAllPerson() {
		List<Person> persons = personRepository.findAll();
		return convertPersonModelToPersonList(persons);
	}
	
	public List<PersonModel> getPersonById(Long personId) {
		Person person = checkRecordExistInDB(personId);
		List<PersonModel> personModelList = new ArrayList<PersonModel>();
		if(person != null) {
			personModelList.add(convertPersonToPersonModel(person));
		}return personModelList;
	}

	private Person checkRecordExistInDB(Long personId) {
		Person person = personRepository.findById(personId)
				.orElseThrow(()-> new RecordNotFoundException("Person Data not available"));
		return person;
	}

	public void deletePerson(Long personId) {
		Person person = checkRecordExistInDB(personId);
		if(person != null) {
			personRepository.deleteById(personId);
		}
	}
	
	public void updatePerson(PersonModel personModel) {
		Person perDb = checkRecordExistInDB(personModel.getPersonId());
		if(perDb != null) {
			Person person = convertPersonModelToPerson(personModel, perDb.getHobby());
			person.setId(personModel.getPersonId());
			personRepository.saveAndFlush(person);
		}
		
	}
	
	private List<PersonModel> convertPersonModelToPersonList(List<Person> persons) {
		List<PersonModel> personModelList = new ArrayList<PersonModel>();
		if(persons != null && persons.size() > 0) {
			for(Person person: persons) {
				personModelList.add(convertPersonToPersonModel(person));
			}
		}
		return personModelList;
		
	}
	
	private PersonModel convertPersonToPersonModel(Person person) {
		if(person != null ) {
			PersonModel personModel = new PersonModel();
			personModel.setPersonId(person.getId());
			personModel.setFirst_name(person.getFirst_name());
			personModel.setLast_name(person.getLast_name());
			personModel.setAge(person.getAge());
			personModel.setFavourite_colour(person.getFavourite_colour());
			if(person.getHobby() != null) {
				List<String> hobbies = new ArrayList<>();
				for(Hobby hobby : person.getHobby()) {
					hobbies.add(hobby.getHobbyName());
				}
				personModel.setHobby(hobbies);	
			}
			return personModel;
		}
		return null;
	}
	private Person convertPersonModelToPerson(PersonModel personModel) {
		return convertPersonModelToPerson(personModel, null);
	}
	private Person convertPersonModelToPerson(PersonModel personModel, List<Hobby> personHobbies) {
		if(personModel != null ) {
			Person person = new Person();
			person.setFirst_name(personModel.getFirst_name());
			person.setLast_name(personModel.getLast_name());
			person.setAge(personModel.getAge());
			person.setFavourite_colour(personModel.getFavourite_colour());
			if(personModel.getHobby() != null) {
				List<Hobby> hobbies = new ArrayList<>();
				List<String> personHobbys = new ArrayList<>();
				if(personHobbies != null) {
					personHobbys = personHobbies.stream().map(hobby->hobby.getHobbyName()).collect(Collectors.toList());
				}
				for(String hobbyStr : personModel.getHobby()) {
					if(!personHobbys.contains(hobbyStr)){
						Hobby hobby = new Hobby();
						hobby.setHobbyName(hobbyStr);
						hobby.setPerson(person);
						hobbies.add(hobby);
					}
					
				}
				person.setHobby(hobbies);	
			}
			return person;
		}
		return null;
	}

	

	
	
}
