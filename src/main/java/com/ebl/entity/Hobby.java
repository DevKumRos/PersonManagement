package com.ebl.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Hobby {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="hobby_name")
    private String hobbyName;
    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHobbyName() {
		return hobbyName;
	}
	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
    
    
    
}
