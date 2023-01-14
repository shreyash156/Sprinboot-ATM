package com.project.springbootATM.service;

import java.util.List;

import com.project.springbootATM.model.Transactions;
import com.project.springbootATM.model.User;

public interface AdminService {
	
	 List<User> getAllUsers();
	 User findUserByAccNo(String accno);
	 User updateUser(int rid, User user);
	 void deleteUser(int accno);
     List<Transactions> getTransactions(Long accno);

}
