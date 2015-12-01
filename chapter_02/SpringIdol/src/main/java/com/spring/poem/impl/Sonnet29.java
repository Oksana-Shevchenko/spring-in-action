package com.spring.poem.impl;

import com.spring.poem.IPoem;

public class Sonnet29 implements IPoem{
	private static String[] LINES = {
		"Aaaaaa aaaaaaa",
		"Bbbbbb bbbbb bbb"
	};
	
	public Sonnet29() {	}
	
	public void recite() {
		for (int i=0; i<LINES.length; i++) {
			System.out.println(LINES[i]);
		}
	}
}
