package com.capgemini.healthcaresystem.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.dao.AbstractUsers;
import com.capgemini.healthcaresystem.service.MapValidationErrorService;
import com.capgemini.healthcaresystem.service.AbstractUsersService;

@RestController
@RequestMapping("/api/users")
public class AbstractUsersController {
		@Autowired
		AbstractUsersService userService;
		
		@Autowired
		MapValidationErrorService mapValidationErrorService;
		
		@PostMapping("")
		public ResponseEntity<?> addUsers(@Valid @RequestBody AbstractUsers user, BindingResult result){
			ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
			if(errorMap!=null) return errorMap;
			AbstractUsers saveUser=userService.addUsers(user);
			return new ResponseEntity<AbstractUsers>(saveUser,HttpStatus.CREATED);
		}
}
