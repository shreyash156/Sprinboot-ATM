package com.project.springbootATM.serviceImpl;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.springbootATM.model.Account;
import com.project.springbootATM.model.User;
import com.project.springbootATM.repository.AccountDao;
import com.project.springbootATM.repository.UserDao;
import com.project.springbootATM.service.AccountService;

@Service 
public class AccountserviceImpl implements AccountService {

	@Autowired
	private AccountDao accdao;
	@Autowired
	private UserDao userdao;
	@Autowired
	private BCryptPasswordEncoder encodePassword;

	@Override
	public User createAccount(User newuser) {
		Random random = new Random();
		Long accnumber = Math.abs((random.nextLong() % 90000000L) + 5040935000000000L);
		String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
	

		System.out.println("Account No:" + accnumber);
		System.out.println("PinNumber: " + pinnumber);

		Account acc = new Account();
		
		acc.setAccno(accnumber);
		acc.setPin(encodePassword.encode(pinnumber));
        acc.setBalance(200);
		accdao.save(acc);
		
		
		
		newuser.setAccount(acc);
		newuser.setRole("ROLE_USER");
		newuser.setDate(new Date());
		userdao.save(newuser);
		
		
		
		
		
		return newuser;

	}
	

	
	

}
