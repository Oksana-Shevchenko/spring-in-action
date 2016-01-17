package com.spring.mind.impl;

import com.spring.mind.IThinker;

public class Volunteer implements IThinker {
	private String thoughts;
	
	public void thinkOfSomething(String thoughts) {
		this.thoughts = thoughts;
	}
	public String getThoughts() {
		return thoughts;
	}
}
