package com.ebl.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class PersonData {

	private List<PersonModel> person = new ArrayList<>();

	public List<PersonModel> getPerson() {
		return person;
	}

	public void setPerson(List<PersonModel> person) {
		this.person = person;
	}
	
}
