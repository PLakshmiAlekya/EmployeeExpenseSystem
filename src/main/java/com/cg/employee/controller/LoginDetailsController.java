package com.cg.employee.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employee.constants.Constants;
import com.cg.employee.dto.SuccessMessage;
import com.cg.employee.entity.LoginDetails;
import com.cg.employee.exception.ValidateException;
import com.cg.employee.serviceImpl.LoginService;


@RestController
public class LoginDetailsController {
	@Autowired
	LoginService logService;

	//not working
	@PostMapping("/addUser")
	public SuccessMessage addDetails(@RequestBody LoginDetails details) throws LoginException, ValidateException {
		//LoginDetails user = logService.addDetails(details);
		logService.addDetails(details);
		return new SuccessMessage(Constants.USER_ADDED);
	}
	

	//working
//	@DeleteMapping("/deleteUser/{id}")
//	public void deleteDetailsById(@PathVariable ("id") int id) throws LoginException {
//		  logService.deleteDetailsById(id);	 
//	}
	
	//working
	@DeleteMapping("/deleteUser/{id}")
	public SuccessMessage deleteDetailsById(@PathVariable ("id") int id) throws LoginException {
		  logService.deleteDetailsById(id);
		 return new SuccessMessage(Constants.USER_DELETED);		 
	}
	//working
	@PostMapping("/validateUser")
	public SuccessMessage validateUser(@RequestBody LoginDetails details) throws  ValidateException {
		 logService.validateUser(details);
		 return new SuccessMessage(Constants.USER_VALIDATION);
		}
			
	@PostMapping("/login")
	public String login(@RequestBody LoginDetails details) throws LoginException{
		return logService.login(details);
	}
	
	@PostMapping("/logout")
	public LoginDetails logout(LoginDetails details) throws LoginException{
		return logService.logout(details);
	}
	
	

}