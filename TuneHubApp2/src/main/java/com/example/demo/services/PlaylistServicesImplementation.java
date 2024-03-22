package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlayListRepository;

@Service
public class PlaylistServicesImplementation implements PlaylistService{
	
	@Autowired
	PlayListRepository prepo;

	@Override
	public String addPlaylist(Playlist playlist) {
		prepo.save(playlist);
		return "Playlist created";
	}

	@Override
	public List<Playlist> fetchPlaylist() {
		List<Playlist> playlist = prepo.findAll();
		return playlist;
	}

}
