package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Playlist;

public interface PlaylistService 
{
	
	public String addPlaylist(Playlist playlist);

	public List<Playlist> fetchPlaylist();
	

}
