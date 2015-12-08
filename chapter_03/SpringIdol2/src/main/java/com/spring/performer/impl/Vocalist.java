package com.spring.performer.impl;

import com.spring.performer.IPerformer;

public class Vocalist implements IPerformer {
	private String song;
	
	public Vocalist() {}
	
	public void perform() throws PerformerException {
		System.out.println("Singing song: "+song+ " : ");
	}

	public String screamSong() {
		return song;
	}
	
	public void setSong(String song) {
		this.song = song;
	}
	
	public String getSong() {
		return song;
	}
}
