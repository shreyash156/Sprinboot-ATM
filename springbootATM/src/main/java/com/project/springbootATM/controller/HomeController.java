package com.project.springbootATM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springbootATM.model.Account;
import com.project.springbootATM.model.User;
import com.project.springbootATM.repository.AccountDao;
import com.project.springbootATM.repository.UserDao;
import com.project.springbootATM.serviceImpl.AccountserviceImpl;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {

	@Autowired
	private UserDao userdao;
	@Autowired
	private AccountDao accdao;

	@Autowired
	private AccountserviceImpl accservice;



	@PostMapping("/signup")

	public User register(@RequestBody User newuser) {

		return accservice.createAccount(newuser);
	}

	@PostMapping("/signin")
	public ResponseEntity<Account> loginUser(@RequestBody Account regdata) {

		Account acc = accdao.findByAccno(regdata.getAccno());
		System.out.println(regdata.getAccno() + regdata.getPin());
		if (acc.getPin().equals(regdata.getPin())) {
			return ResponseEntity.ok(acc);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
