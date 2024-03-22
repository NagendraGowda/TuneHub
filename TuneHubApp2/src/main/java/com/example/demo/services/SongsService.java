package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Songs;

public interface SongsService {
	
	public String addSongs(Songs song);
	
	public boolean songExist(String name);
	
	public List<Songs> fetchSongs();

	public void updateSong(Songs song);

}
