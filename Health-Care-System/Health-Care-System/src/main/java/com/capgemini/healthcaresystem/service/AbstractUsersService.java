package com.capgemini.healthcaresystem.service;

import com.capgemini.healthcaresystem.dao.AbstractUsers;

public interface AbstractUsersService {
	public AbstractUsers validateUsers(String userName,String password);
	public AbstractUsers addUsers(AbstractUsers user);
	public AbstractUsers removeUsers(AbstractUsers user);
}
