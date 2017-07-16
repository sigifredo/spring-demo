package com.nullpoint.demo.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nullpoint.demo.entity.UserRole;
import com.nullpoint.demo.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.nullpoint.demo.entity.User user = userRepository.findByUsername(username);
		return buildUser(user, buildAuthorities(user.getUserRole()));
	}

	private User buildUser(com.nullpoint.demo.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();

		for (UserRole userRole : userRoles)
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));

		return new ArrayList<GrantedAuthority>(auths);
	}
}
