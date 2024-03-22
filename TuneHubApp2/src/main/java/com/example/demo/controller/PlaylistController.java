package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Songs;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PlaylistController {

	@Autowired
	PlaylistService pserv;

	@Autowired
	SongsService sserv;

	@GetMapping("playlist")
	public String createPlaylist(Model model) {
		List<Songs> songlist = sserv.fetchSongs();
		model.addAttribute("songslist", songlist);
		return "createplaylist";

	}

	@PostMapping("addplaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		pserv.addPlaylist(playlist);
		List<Songs> songs = playlist.getSongs();
		for (Songs song : songs) {
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		return "playlistsuccess";
	}
	
	@GetMapping("viewplaylist")
	public String viewPlaylist(Model model) {
		List<Playlist> plist = pserv.fetchPlaylist();
		model.addAttribute("plist",plist);
		return "viewplaylists";
		
	}

}
