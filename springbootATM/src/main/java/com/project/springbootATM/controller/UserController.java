package com.project.springbootATM.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.springbootATM.model.Account;
import com.project.springbootATM.model.Transactions;
import com.project.springbootATM.model.User;
import com.project.springbootATM.repository.TransactionDao;
import com.project.springbootATM.repository.UserDao;
import com.project.springbootATM.serviceImpl.TransactionServiceImpl;
import com.project.springbootATM.serviceImpl.UserServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
//@RequestMapping("/user")
public class UserController {

	@Autowired
	private TransactionServiceImpl transactservice;

	@Autowired
	UserServiceImpl userservice;

	@PostMapping("/deposit/{amount}")
	public void deposit(@PathVariable("amount") double amount/* ,Principal principle */) {

		// System.out.println(principle.getName());
		System.out.println("Deposit Amount:" + amount);
		transactservice.deposit(amount, /* Long.parseLong(principle.getName() */5040935054862027L);
	}

	@PostMapping("/withdraw/{amount}")
	public void withdraw(@PathVariable("amount") double amount, Principal principal) {

		System.out.println("Withdraw Amount:" + amount);
		transactservice.withdraw(amount, /* Long.parseLong(principal.getName() */5040935054862027L);
	}

	@GetMapping("user/transactions")
	public List<Transactions> trasactions(Principal principal) {
		System.out.println("Show All Transactions..........");

		return userservice.getAllTransactions(principal.getName());
	}

	@PutMapping("/pinchange/{pin}")
	public Account updateUser(@PathVariable("pin") String pinnumber/* ,Principal principal */) {
		System.out.println("ChangingPin..........");

		return userservice.pinChange(pinnumber, /* principal.getName() */"5040935054862027");
	}

	@GetMapping("user/profile")
	@ResponseBody
	public List showUserProfile(Principal principal) {
		
		System.out.println(principal.getName());
		return userservice.profile(principal.getName());

	}

}
