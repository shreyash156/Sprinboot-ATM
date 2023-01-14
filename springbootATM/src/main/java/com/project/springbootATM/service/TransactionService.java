package com.project.springbootATM.service;



import com.project.springbootATM.model.Transactions;


public interface TransactionService {
	

	public Transactions deposit(double amount,long accno);
	public Transactions withdraw( double amount,long accno );



}
