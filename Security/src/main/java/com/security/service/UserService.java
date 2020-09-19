package com.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.domain.UserDto;
import com.security.mapper.UserMapper;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public void addUser(UserDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userMapper.addUser(userDto);
		userMapper.setRole(userDto.getIdx());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto = userMapper.getUserByEmail(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (userDto.getRole().equals("MEMBER")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
		} else if(userDto.getRole().equals("ADMIN")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		return new User(userDto.getEmail(), userDto.getPassword(), authorities);
	}
	

}
