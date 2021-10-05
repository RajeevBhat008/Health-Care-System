package com.capgemini.healthcaresystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.AbstractUsers;
import com.capgemini.healthcaresystem.repository.AbstractUsersRepository;
import com.capgemini.healthcaresystem.service.AbstractUsersService;
@Service
public class AbstractUsersServiceImpl implements AbstractUsersService {
	
	@Autowired
	AbstractUsersRepository userRepository;
	
	@Override
	public AbstractUsers validateUsers(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractUsers addUsers(AbstractUsers user) {
		return userRepository.save(user);
	}

	@Override
	public AbstractUsers removeUsers(AbstractUsers user) {
		// TODO Auto-generated method stub
		return null;
	}

}
