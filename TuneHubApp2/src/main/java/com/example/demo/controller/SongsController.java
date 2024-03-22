package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Songs;
import com.example.demo.services.SongsService;
import com.example.demo.services.SongsServicesImplementation;


   
@Controller
public class SongsController {
	
	
	@Autowired
	SongsService sserv;
	
	@PostMapping("addsongs")
	public String addSongs(Songs song) {
		boolean songStatus = sserv.songExist(song.getName());
		if(songStatus==false) {
		sserv.addSongs(song);
		return "songsuccess";
		}
		else {
			return "songexist";
		}
	}
	
	@GetMapping("showsongs")
	public String showSongs(Model model){
		List<Songs> songList = sserv.fetchSongs();
		model.addAttribute("songslist",songList);
		return "displaysongs";
	}
	
	@GetMapping("customersongs")
	public String viewSongs(Model  model) {
		boolean primeStatus = true;
		if(primeStatus == true) {
			List<Songs> songlist = sserv.fetchSongs();
			model.addAttribute("songslist",songlist);
			return "customerSongs";
		}
		else {
			return "makepayment";
		}
	}
	
}
