package com.project.springbootATM.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.project.springbootATM.model.Account;
import com.project.springbootATM.model.Transactions;
import com.project.springbootATM.model.User;
import com.project.springbootATM.repository.AccountDao;
import com.project.springbootATM.repository.UserDao;
import com.project.springbootATM.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserDao userdao;
	@Autowired
	private AccountDao accdao;

	
	@Override
	public List<User> getAllUsers() {
		List<User> users = userdao.findAll();
		return users;
	}

	@Override
	public User updateUser(int rid, User user) {

		// Optional<User> user=userdao.findById(rid;

		User updateuser = userdao.getuserByUserId(rid);

		updateuser.setFirstName(user.getFirstName());
		updateuser.setMiddleName(user.getMiddleName());
		updateuser.setLastName(user.getLastName());
		updateuser.setEmail(user.getEmail());
		updateuser.setMobile(user.getMobile());
		updateuser.setAdhar(user.getAdhar());
		updateuser.setPan(user.getPan());
		updateuser.setDob(user.getDob());

		User updateduser = userdao.save(updateuser);

		return updateduser;
	}

	
	@Override
	public void deleteUser(int userid) {
		//User deleteUser=userdao.getuserByUsername(Long.toString(accno));
		         userdao.deleteById(userid);
		

	}

	
	@Override
	public List<Transactions> getTransactions(Long accno) {

		Account acc = accdao.findByAccno(accno);

		return acc.getTransactions();

	}

	public User findUserByAccNo(String accno) {
		 
		User currentUser=userdao.getuserByUsername(accno);
		
		return currentUser;
	}

}
