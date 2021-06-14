package com.cg.employee.service;

import javax.security.auth.login.LoginException;

import com.cg.employee.entity.LoginDetails;
import com.cg.employee.exception.ValidateException;

public interface ILoginService {
	public LoginDetails addDetails(LoginDetails details) throws LoginException,ValidateException;		
	public void deleteDetailsById(int id) throws LoginException;
	public LoginDetails validateUser(LoginDetails details) throws ValidateException;
	public LoginDetails logout(LoginDetails details) throws LoginException;
}
