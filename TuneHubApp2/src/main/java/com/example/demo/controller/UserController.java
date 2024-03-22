package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Songs;
import com.example.demo.entities.Users;
import com.example.demo.services.SongsService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UsersService users;
	
	@Autowired
	SongsService sserv;

	

	@PostMapping("register")
	public String addUser(Users user) {

		boolean userstatus = users.emailExist(user.getEmail());
		if (userstatus == false) {

			users.addUser(user);
			return "registersuccessful";
		} 
		else {
			return "registerfailed";
		}
	}
	
	@PostMapping("/login")
	public String validateUser(@RequestParam String email, @RequestParam String password,HttpSession session) {
		boolean loginstatus = users.validateUser(email,password);
		if(loginstatus==true) {
			
			session.setAttribute("email", email);
			String role = users.getRole(email);
			if(role.equals("Admin")) {
				return "admin";
			}
			else {
				return "customer";
			}
		}
		else {
			return "loginfailure";
		}
	}
	
	@GetMapping("exploresongs")
	public String exploreSongs(HttpSession session,Model model) {
		
		   String email = (String) session.getAttribute("email");
		   Users user = users.getUser(email);
		   boolean userStatus = user.isPremium();
		   if(userStatus==true) {
			   List<Songs> songList = sserv.fetchSongs();
				model.addAttribute("songslist",songList);
			   return "displaysongs";
		   }
		   else {
			   return "payment";
		   }
		
	}
}
