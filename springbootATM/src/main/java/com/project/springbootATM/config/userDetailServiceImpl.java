package com.project.springbootATM.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.springbootATM.model.User;
import com.project.springbootATM.repository.UserDao;

public class userDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userdao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// fetching User From Repository

		User user = userdao.getuserByUsername(username);


		if (user == null) {
			throw new UsernameNotFoundException("Could NOt found useName");

		}

		customUserDetails customUserDetail = new customUserDetails(user);

		return customUserDetail;
	}

}