package com.spring;

public class Coconut {
	private Lime lime;
	
	public Coconut() {}
	
	public void setLime(Lime lime) {
		this.lime = lime; 
	}
	
	public void drinkThemBothUp() {
		System.out.println("You put the lime in the coconut...");
		System.out.println("and drink ‘em both up...");
		System.out.println("You put the lime in the coconut...");
		lime.drink(); 
	}
}
