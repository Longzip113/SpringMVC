package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SimpleAliasRegistry;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.longnguyen.constant.SystemConstant;
import com.longnguyen.dto.MyUser;
import com.longnguyen.entity.RoleEntity;
import com.longnguyen.entity.UserEntity;
import com.longnguyen.repository.UserRepository;


// Phần này làm authentication 
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		
		if(userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for (RoleEntity roleEntity : userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(roleEntity.getCode()));
		}
		//put thông tin vào security khi user login vào hệ thống
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassWord(), true, true,
							true, true, authorities);
		myUser.setFullName(userEntity.getFullName());
		
		// vì myuser extent từ user mà user implements từ UserDetails nên return Myuser đc;
		return myUser;
	}

}
