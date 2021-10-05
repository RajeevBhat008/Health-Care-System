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
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String role;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="User_id", nullable= false)
	@JsonIgnore
	private AbstractUsers adminusers;
	public Admin()
	{
	}
	public int getId() {
		return id;
	}
	public void setId(int Id) {
		this.id = Id;
	}
	
	public String getRole() {
		return role;
	}
	public void setAdminUsers(AbstractUsers adminusers) {
		this.adminusers = adminusers;
	}
	public AbstractUsers getUsers() {
		return adminusers;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
