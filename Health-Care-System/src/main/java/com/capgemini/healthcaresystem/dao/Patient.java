package com.capgemini.healthcaresystem.dao;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pateintId;
	@NotBlank(message="name cannot be empty")
	private String name;
	@NotBlank(message="phoneNo cannot be empty")
	private String phoneNo;
	@NotBlank(message="age cannot be empty")
	private int age;
	@NotBlank(message="gender cannot be empty")
	private String gender;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="role", nullable = false)
	@JsonIgnore
	private AbstractUsers users;
	public Patient() {
		
	}
	public int getPateintId() {
		return pateintId;
	}
	public void setPateintId(int pateintId) {
		this.pateintId = pateintId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
