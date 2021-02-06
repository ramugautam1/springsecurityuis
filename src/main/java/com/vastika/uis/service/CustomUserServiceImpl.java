package com.vastika.uis.service;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vastika.uis.model.User;
import com.vastika.uis.repository.UserRepository;

@Service
@Transactional
public class CustomUserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		System.out.println("username from custom user detail service: " + user.getUserName());
		UserDetails u = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				true, true, true, true, getAuthorities(user.getRole().getRoleName()));
		return u;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(String roleName){
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(roleName));
		return authorities;
	}

}