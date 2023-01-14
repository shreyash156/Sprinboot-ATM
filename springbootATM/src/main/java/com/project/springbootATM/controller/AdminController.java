package com.project.springbootATM.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springbootATM.model.Transactions;
import com.project.springbootATM.model.User;
import com.project.springbootATM.repository.AccountDao;
import com.project.springbootATM.repository.TransactionDao;
import com.project.springbootATM.repository.UserDao;
import com.project.springbootATM.serviceImpl.AdminServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
/* @RequestMapping("/admin") */
public class AdminController {

	@Autowired
	private AdminServiceImpl adminservice;

	@GetMapping("/getAll")
	public List<User> getUsers() {

		return adminservice.getAllUsers();

	}

	@GetMapping("/getUser/{accno}")
	public User register(@PathVariable("accno") String accno) {
		System.out.println("Get user by aac no-----------");
		return adminservice.findUserByAccNo(accno);
	}

	@GetMapping("/transactions/{accno}")
	public List<Transactions> trasactions(@PathVariable("accno") Long accno) {
		System.out.println("Get All transactions...........");
		return adminservice.getTransactions(accno);
	}

	@PutMapping("/updateUser/{userid}")
	public User updateUser(@PathVariable("userid") int userid, @RequestBody User user) {
		System.out.println("UpdatingUser..........");

		return adminservice.updateUser(userid, user);
	}

	@DeleteMapping("/deleteUser/{accno}")
	public void deleteUser(@PathVariable("accno") int accno) {
		System.out.println("DeletingUser..........");

		adminservice.deleteUser(accno);

	}

}
