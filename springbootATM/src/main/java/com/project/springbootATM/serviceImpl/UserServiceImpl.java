package com.project.springbootATM.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.springbootATM.model.Account;
import com.project.springbootATM.model.Transactions;
import com.project.springbootATM.model.User;
import com.project.springbootATM.repository.AccountDao;
import com.project.springbootATM.repository.TransactionDao;
import com.project.springbootATM.repository.UserDao;
import com.project.springbootATM.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	@Autowired
	private AccountDao accdao;
	@Autowired
	private TransactionDao transactdao;
	@Autowired
	private BCryptPasswordEncoder encodePassword;

	@Override
	public List<Transactions> getTransactions(Long accno) {

		Account acc = accdao.findByAccno(accno);

		return acc.getTransactions();

	}

	public List<Transactions> getAllTransactions(String accno) {

		return transactdao.findAllTransactions(Long.parseLong(accno));
	}

	@Override
	public Account pinChange(String pinnumber, String accno) {

		Account acc = accdao.findByAccno(Long.parseLong(accno));

		acc.setPin(encodePassword.encode(pinnumber));

		accdao.save(acc);

		return acc;
	}

	public List profile(String name) {

		User localuser = userdao.getuserByUsername(name);

		List list = new ArrayList();
		list.add(localuser.getUserid());
		list.add(localuser.getFirstName());
		list.add(localuser.getMiddleName());
		list.add(localuser.getLastName());
		list.add(localuser.getDob());
		list.add(localuser.getMobile());
		list.add(localuser.getEmail());
		list.add(localuser.getGender());
		list.add(localuser.getMaritalStatus());
		list.add(localuser.getAdhar());
		list.add(localuser.getPan());
		list.add(localuser.getAddress());
		list.add(localuser.getCity());
		list.add(localuser.getCountry());
		list.add(localuser.getAccount().getAccno());
		list.add(localuser.getAccount().getBalance());

		return list;
	}

}
