package com.NiksIT.UserMngmntApp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.NiksIT.UserMngmntApp.bindings.LoginForm;
import com.NiksIT.UserMngmntApp.bindings.UnlockAccountForm;
import com.NiksIT.UserMngmntApp.bindings.UserForm;
import com.NiksIT.UserMngmntApp.entities.City;
import com.NiksIT.UserMngmntApp.entities.Country;
import com.NiksIT.UserMngmntApp.entities.State;
import com.NiksIT.UserMngmntApp.entities.UserAccounts;
import com.NiksIT.UserMngmntApp.repositories.CityRepository;
import com.NiksIT.UserMngmntApp.repositories.CountryRepository;
import com.NiksIT.UserMngmntApp.repositories.StateRepository;
import com.NiksIT.UserMngmntApp.repositories.UserAccountRepository;

import net.bytebuddy.utility.RandomString;

public class UserServiceImpl implements UserServiceI {
	
	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;


	@Override
	public String loginCheck(LoginForm loginForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getCountries() {
		List<Country> countries = countryRepository.findAll();
		Map<Integer, String> counrtymap = new HashMap<Integer, String>();

		countries.forEach(country -> {
			counrtymap.put(country.getCountryId(), country.getCountryname());
		});
		return counrtymap;
		
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		List<State> states = stateRepository.findByCountryId(countryId);
		Map<Integer, String> stateMap = new HashMap<Integer, String>();

		states.forEach(state -> {
			stateMap.put(state.getStateId(), state.getStateName());
		});

		return stateMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		Map<Integer, String> cityMap = new HashMap<Integer, String>();

		List<City> cities = cityRepository.findByStateId(stateId);

		cities.forEach(city -> {
			cityMap.put(city.getCityId(), city.getCityName());
		});

		return cityMap;
	}

	@Override
	public boolean emailUnique(String email) {
         UserAccounts user = userAccountRepository.findByEmail(email);
		 
		 if(user == null) {
			 return true;
		 }
		 return false;
	}

	@Override
	public boolean saveUser(UserForm userForm) {
		userForm.setAccStatus("LOCKED");
		userForm.setPassword(generateTempPassword());
		
		
		UserAccounts entity=new UserAccounts();
		
		BeanUtils.copyProperties(userForm,entity);
		UserAccounts save = userAccountRepository.save(entity);
		
		if(save.getUserId() !=null) {
			
			return true;
		}
		
		return false;

	}

	@Override
	public boolean unlockAccount(UnlockAccountForm unlockAccForm) {
		String email = unlockAccForm.getEmail();
		String tempPwd = unlockAccForm.getTempPwd();
		
		UserAccounts user = userAccountRepository.findByEmailAndPassword(email, tempPwd);
		
		if(user !=null) {
			user.setAccStatus("UNLOCKED");
			user.setPassword(unlockAccForm.getNewPwd());
			userAccountRepository.save(user);
			return true;
		}
		return false;

	}

	@Override
	public String forgotPwd(String emailId) {
		UserAccounts user = userAccountRepository.findByEmail(emailId);
		if (user !=null) {
			//send mail with new password
			return "SUCCESS";
		}
		
		return "FAIL";
	}
	
   // private String generateTempPassword() {
		
    	//String randomTest = RandomStringUtils.randomAlphanumeric(6);
		//return randomTest;
	//}


}
