package com.spring.knight.impl;

import com.spring.knight.IKnight;
import com.spring.quest.IQuest;

public class BraveKnight implements IKnight {
	private IQuest quest;
	
	public BraveKnight(IQuest quest) {
		this.quest = quest;
	}
	
	public void embarkOnQuest() {
		quest.embark();
	}
}
