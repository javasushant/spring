package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.User;
import com.nt.repository.UserRepo;
@Service("loginservice")
public class LoginServiceImpl implements ILoginService {
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public String validate(User user) {
		//use Repository
		int  count=userRepo.authenticate(user.getUsername(), user.getPassword());
		return count ==0?"Invalid Credentials ":"Valid Credentials ";
	}

}
