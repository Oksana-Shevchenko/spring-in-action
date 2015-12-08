package com.spring.performer.impl;

import com.spring.magicBox.IMagicBox;
import com.spring.performer.IPerformer;

public class Magician implements IPerformer{
	private IMagicBox magicBox;
	private String magicWords;
	
	public Magician() {}
	
	public void perform() throws PerformerException {
		System.out.println(magicWords);
		System.out.println("The magic box contains...");
		System.out.println(magicBox.getContents());
	}
	
	public void setMagicBox(IMagicBox magicBox) {
		this.magicBox = magicBox; 
	}
	public void setMagicWords(String magicWords) {
		this.magicWords = magicWords;
	}
}
