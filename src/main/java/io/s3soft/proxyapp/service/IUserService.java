package io.s3soft.proxyapp.service;

import java.util.List;

import io.s3soft.proxyapp.model.User;

public interface IUserService {
	public User getUserByEmail(String email);
	public List<User> getAllUsers();
}
