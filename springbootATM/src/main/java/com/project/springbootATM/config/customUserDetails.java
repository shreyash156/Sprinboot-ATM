package com.project.springbootATM.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.springbootATM.model.User;

public class customUserDetails implements UserDetails {

	
	private User user;

	public customUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
		System.out.println("security config fetching simplegrantedauthority from database:"+simpleGrantedAuthority);
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		System.out.println("security config fetching password from database:"+user.getAccount().getPin());
		return user.getAccount().getPin();
	}

	public String getUsername() {
		// TODO Auto-generated method stub

		String username = Long.toString(user.getAccount().getAccno());

		System.out.println("security config fetching username from database:"+username);
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
