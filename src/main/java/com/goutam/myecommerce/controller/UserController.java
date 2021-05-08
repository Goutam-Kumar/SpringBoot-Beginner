package com.goutam.myecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goutam.myecommerce.entities.User;
import com.goutam.myecommerce.userservice.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String home() {
		return "This is Home";
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return this.userService.getUsers();
	}
	
	@GetMapping("users/{userId}")
	public User getUserDetails(@PathVariable String userId) {
		return this.userService.getUserDetails(Long.parseLong(userId));
	}
	
	@PostMapping("/users")
	public List<User> addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		return this.userService.updateUser(user);
	}
	
	@DeleteMapping("users/{userId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId) {
		try {
			this.userService.deleteUser(Long.parseLong(userId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
