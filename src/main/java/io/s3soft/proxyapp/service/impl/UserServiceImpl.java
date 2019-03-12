package io.s3soft.proxyapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.s3soft.proxyapp.model.User;
import io.s3soft.proxyapp.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	public RestTemplate restTemplate;

	@Override
	public User getUserByEmail(String email) {
		User user=restTemplate.getForObject("https://s3food-users.herokuapp.com/users/"+email.toLowerCase(),User.class);
		return user;
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> user=restTemplate.getForObject("https://s3food-users.herokuapp.com/users",List.class);
		return user;
	}
}
