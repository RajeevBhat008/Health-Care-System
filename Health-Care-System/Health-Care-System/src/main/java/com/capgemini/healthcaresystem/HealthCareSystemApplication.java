package com.capgemini.healthcaresystem;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.healthcaresystem.dao.Admin;
import com.capgemini.healthcaresystem.repository.AbstractUsersRepository;
import com.capgemini.healthcaresystem.repository.AdminRepository;
import com.capgemini.healthcaresystem.dao.AbstractUsers;

@SpringBootApplication
public class HealthCareSystemApplication {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	AbstractUsersRepository abstractUsersRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HealthCareSystemApplication.class, args);
	}
	
	@PostConstruct
	protected void init() {
		AbstractUsers user=new AbstractUsers();
		Admin admin=new Admin();
		user=createAdmin("Rajeev","Rajeev123","ADMIN");
		admin.setRole(user.getRole());
		 
		admin.setAdminUsers(user);
		
		abstractUsersRepository.save(user);
		
		adminRepository.save(admin);
		
	}
	
	private AbstractUsers createAdmin(String username,String password,String role) {
		AbstractUsers user=new AbstractUsers();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		return user;
	}

}
