package com.capgemini.healthcaresystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.capgemini.healthcaresystem.dao.AbstractUsers;

public interface AbstractUsersRepository extends JpaRepository<AbstractUsers, Integer> {
	 AbstractUsers findById(int  id); 
	 	AbstractUsers findByRole(String role);
	
}
