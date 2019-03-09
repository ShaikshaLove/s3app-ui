package io.s3soft.proxyapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.s3soft.proxyapp.model.User;
import io.s3soft.proxyapp.service.IUserService;

/**
 * @author shaiksha
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService{
	
	
	
	@Autowired
	private IUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		System.out.println("---> From ladUserByUserName()");
		User user=userService.getUserByEmail(email);
		boolean accountNonExpired=true;
		boolean credentialsNonExpired=true;
		boolean accountNonLocked=true;

		if (user == null) {
			throw new UsernameNotFoundException(
					"No user found with username: "+ email);
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail().toLowerCase(),
				user.getPassword(),
				user.isEnabled(), 
				accountNonExpired, 
				credentialsNonExpired,
				accountNonLocked, 
				getAuthorities(user.getRoles())
				);
	}

	 private static List<GrantedAuthority> getAuthorities (List<String> roles) {
	        List<GrantedAuthority> authorities = new ArrayList<>();
	        for (String role : roles) {
	            authorities.add(new SimpleGrantedAuthority(role));
	        }
	        return authorities;
	    }

	
	}
