package com.goutam.myecommerce.userservice;

import java.util.List;

import com.goutam.myecommerce.entities.User;

public interface UserService {
	public List<User> getUsers();

	public User getUserDetails(Long id);

	public List<User> addUser(User user);

	public User updateUser(User user);
	
	public void deleteUser(Long userId);
}
