package com.project.springbootATM.serviceImpl;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.project.springbootATM.model.Account;
import com.project.springbootATM.model.Transactions;
import com.project.springbootATM.repository.AccountDao;
import com.project.springbootATM.repository.TransactionDao;
import com.project.springbootATM.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private AccountDao accdao;

	@Autowired
	private TransactionDao transdao;

	@Override
	public Transactions deposit(double amount, long accno) {

		Transactions transact = new Transactions();

		if (amount > 0) {

			Account account = accdao.findByAccno(accno);
			double Balance = account.getBalance();

			double TotalBalance = (Balance + amount);

			transact.setAccount(account);
			transact.setAmount(amount);
			transact.setDate(new Date());
			transact.setStatus("Success");
			transact.setTransacttype("Deposit");
			transact.setAvailableBalance(TotalBalance);
			accdao.save(account);

			account.setBalance(TotalBalance);
			transdao.save(transact);

		} else {
			System.out.println("error you enter negative or zero amount");
		}
		return transact;

	}

	public Transactions withdraw(double amount, long accno) {

		Transactions transact = new Transactions();
		Account account = accdao.findByAccno(accno);
		double Balance = account.getBalance();

		if (amount > 0) {
			if (Balance > amount) {

				double TotalBalance = (Balance - amount);
				Date date = new Date();

				transact.setAccount(account);
				transact.setAmount(amount);
				transact.setDate(date);
				transact.setStatus("Success");
				transact.setTransacttype("withdraw");
				transact.setAvailableBalance(TotalBalance);
				accdao.save(account);

				account.setBalance(TotalBalance);
				transdao.save(transact);

			} else {
				System.out.println("you are entered large amount of your current amount");
			}
		} else {
			System.out.println("you are Enter ZERO or NEGAT?IVE number");
		}

		return transact;

	}

}
