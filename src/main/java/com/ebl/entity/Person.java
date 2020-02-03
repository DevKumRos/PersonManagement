package com.ebl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "PERSON")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
	private long id;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="age")
	private int age;
	@Column(name="favourite_colour")
	private String favourite_colour;
	@OneToMany(mappedBy="person", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Hobby.class)
	private List<Hobby> hobby;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFavourite_colour() {
		return favourite_colour;
	}
	public void setFavourite_colour(String favourite_colour) {
		this.favourite_colour = favourite_colour;
	}
	public List<Hobby> getHobby() {
		if (this.hobby == null) {
            this.hobby = new ArrayList<>();
        }
        return this.hobby;
	}
	public void addHobby(Hobby hobby) {
		getHobby().add(hobby);
	}
	public void setHobby(List<Hobby> hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age
				+ ", favourite_colour=" + favourite_colour + ", hobby=" + hobby + "]";
	}
	
	
}
