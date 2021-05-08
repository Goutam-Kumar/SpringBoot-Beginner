package com.goutam.myecommerce.userservice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goutam.myecommerce.dao.UserDao;
import com.goutam.myecommerce.entities.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	//List<User> list;
	
	public UserServiceImpl() {
		/*
		 * list = new ArrayList<User>(); list.add(new User(1, "Goutam",
		 * "goutam.k0711@gmail.com", "123456")); list.add(new User(2, "Arpita",
		 * "arpitaghosh8692@gmail.com", "123456"));
		 */
	}

	@Override
	public List<User> getUsers() {
		//return list;
		return userDao.findAll();
	}

	@Override
	public User getUserDetails(Long id) {
		/*
		 * User u = null; for(User user: list) { if(user.getId() == id) { u = user;
		 * break; } } return u;
		 */
		return userDao.getOne(id);
	}

	@Override
	public List<User> addUser(User user) {
		/*
		 * list.add(user); return list;
		 */
		userDao.save(user);
		return getUsers();
	}

	@Override
	public User updateUser(User user) {
		
		/*
		 * list.forEach(u ->{ if(u.getId() == user.getId()) { u.setName(user.getName());
		 * u.setEmail(user.getEmail()); u.setPassword(user.getPassword()); } });
		 * 
		 * return user;
		 */
		userDao.save(user);
		return user;	
	}

	@Override
	public void deleteUser(Long userId) {
		//list = this.list.stream().filter(u -> u.getId() != userId).collect(Collectors.toList());
		userDao.delete(getUserDetails(userId));
	}

}
