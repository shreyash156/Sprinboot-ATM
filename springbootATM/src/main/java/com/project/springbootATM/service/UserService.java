package com.project.springbootATM.service;

import java.util.List;

import com.project.springbootATM.model.Account;
import com.project.springbootATM.model.Transactions;
import com.project.springbootATM.model.User;

public interface UserService {
	List profile(String name);

	List<Transactions> getTransactions(Long accno);

	Account pinChange(String pinnumber, String name);

}
