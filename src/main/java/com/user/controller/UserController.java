package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.domain.LoginUser;
import com.user.domain.ResetUser;
import com.user.domain.User;
import com.user.service.UserService;

@Controller
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.POST , value="/signupUser")
	public String signupUser(@RequestBody User user) {
		String response = userService.saveUser(user);
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET , value="/loginUser")
	public String loginUser(@RequestBody LoginUser loginUser) {
		List<User> allUsers = userService.getAllUsers();
		String vlidUser = "";

	    for(int i=0; i<allUsers.size(); i++){

	        if(allUsers.get(i).name.equals(loginUser.name)){
	        	if(allUsers.get(i).password.equals(loginUser.password)) {
	        		vlidUser= "valied...!";
	        	} else {
	        		vlidUser = "not valied (:";
	        	}
	        }
	     }
	    return vlidUser;
	}
	
	@RequestMapping(method = RequestMethod.POST , value="/resetUser")
	public String resetPassword(@RequestBody ResetUser resetUser) {
		List<User> allUsers = userService.getAllUsers();
		String vlidUser = "";
		for(int i=0; i<allUsers.size(); i++){

	        if(allUsers.get(i).name.equals(resetUser.name)){
	        	if(resetUser.password.equals(resetUser.confirmPassword)) {
	        		allUsers.get(i).password = resetUser.password;
	        		allUsers.get(i).confirmPassword = resetUser.confirmPassword;
	        		userService.saveUser(allUsers.get(i));
	        		vlidUser = "User updated";
	        	} else {
	        		vlidUser = "error in saving ";
	        	 }
	        }
	     }
		
		return vlidUser;
	}
}
