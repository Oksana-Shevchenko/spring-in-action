package com.spring.mind.impl;

import com.spring.mind.IMindReader;

public class Magician implements IMindReader {
	private String thoughts;
	
	public void interceptThoughts(String thoughts) {
		System.out.println("Intercepting volunteer's thoughts");
		this.thoughts = thoughts;
	}

	public String getThoughts() {
		return thoughts;
	}
}
