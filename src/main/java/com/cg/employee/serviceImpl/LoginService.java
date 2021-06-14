package com.cg.employee.serviceImpl;

import java.util.Optional;
import javax.security.auth.login.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.employee.constants.Constants;
import com.cg.employee.entity.LoginDetails;
import com.cg.employee.exception.ValidateException;
import com.cg.employee.repository.ILoginRepository;
import com.cg.employee.service.ILoginService;

@Service
public class LoginService implements ILoginService {
	@Autowired
	ILoginRepository logRepository;

	public LoginDetails addDetails(LoginDetails details) throws ValidateException, LoginException {
		validateUser(details);
		return logRepository.save(details);
	}

	@Override
	public void deleteDetailsById(int id) throws LoginException {
		Optional<LoginDetails> l = logRepository.findById(id);
		if (l.isPresent()) {
			logRepository.deleteById(id);
		} else {
			throw new LoginException(Constants.USER_ID_DOES_NOT_EXISTS);
		}
	}

	public LoginDetails validateUser(LoginDetails details) throws ValidateException {
		if (!details.getUserName().matches(Constants.USERNAME_PATTERN)) {
			throw new ValidateException(Constants.NAME_CANNOT_BE_EMPTY);
		}
		if (!details.getPassword().matches(Constants.PASSWORD_PATTERN)) {
			throw new ValidateException(Constants.PASSWORD_CANNOT_BE_EMPTY);
		}
		if (!details.getRole().matches(Constants.ROLE_PATTERN)) {
			throw new ValidateException(Constants.ROLE_CANNOT_BE_EMPTY);
		}
		return null;
	}

	@Override
	public LoginDetails logout(LoginDetails details) throws LoginException {
		Optional<LoginDetails> det = logRepository.findById(details.getId());
		if (det.isPresent()) {
			LoginDetails ld = det.get();
			if (ld.isLoggedIn() == true) {
				ld.setLoggedIn(false);
				logRepository.save(ld);
			} else {
				throw new LoginException(Constants.LOGOUT_FAILED);
			}
		}
		return details;
	}

	public String login(LoginDetails details) throws LoginException {
		try {
			if (logRepository.existsById(details.getId()) && details.isLoggedIn() == false
					&& (logRepository.checkpassword(details.getId())).equals(details.getPassword())
					&& (logRepository.checkusername(details.getId())).equals(details.getUserName())) {
				details.setLoggedIn(true);
				logRepository.save(details);
				return "logged in Successfully!!";
			}
			return "Username or Passowrd is Invalid!";
		} catch (Exception e) {
			throw new LoginException("User does not exist");
		}
	}

}