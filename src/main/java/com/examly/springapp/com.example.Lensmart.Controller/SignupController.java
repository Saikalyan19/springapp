package com.example.Lensmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lensmart.model.LoginModel;
import com.example.Lensmart.model.UserModel;
import com.example.Lensmart.repo.userRepo;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class SignupController {
	@Autowired
	userRepo repo;
	@PostMapping("/signup")
	public UserModel saveUser(@RequestBody UserModel user)
	{
		repo.save(user);
		System.out.print(user);
		return user;
	}
	@CrossOrigin("*")
	@GetMapping("/getuser/{email}")
	public UserModel getuser(@PathVariable String email)
	{	
		UserModel user=repo.findById(email).orElse(null);
		return user;
	}

}