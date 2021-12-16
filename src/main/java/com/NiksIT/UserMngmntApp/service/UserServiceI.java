package com.NiksIT.UserMngmntApp.service;

import java.util.Map;

import com.NiksIT.UserMngmntApp.bindings.LoginForm;
import com.NiksIT.UserMngmntApp.bindings.UnlockAccountForm;
import com.NiksIT.UserMngmntApp.bindings.UserForm;

public interface UserServiceI {
	
	public String loginCheck(LoginForm loginForm);

	public Map<Integer, String> getCountries();

	public Map<Integer, String> getStates(Integer countryId);

	public Map<Integer, String> getCities(Integer stateId);

	public boolean emailUnique(String email);

	public boolean saveUser(UserForm userForm);

	public boolean unlockAccount(UnlockAccountForm unlockAccForm);

	public String forgotPwd(String emailId);


}
