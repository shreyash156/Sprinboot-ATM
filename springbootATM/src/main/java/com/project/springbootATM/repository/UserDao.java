package com.project.springbootATM.repository;

import com.project.springbootATM.model.Account;
import com.project.springbootATM.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;



public interface UserDao extends JpaRepository<User, Integer> {

	@Query(value="Select * from User where account_accno=:accno",nativeQuery=true)
	public User getuserByUsername(String accno);
	
	@Query(value="Select * from User where userid=:userid",nativeQuery=true)
	public User getuserByUserId(int userid);



	

}
