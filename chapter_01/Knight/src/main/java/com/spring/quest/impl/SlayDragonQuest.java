package com.spring.quest.impl;

import com.spring.quest.IQuest;

public class SlayDragonQuest implements IQuest{

	public void embark() throws QuestException {
		System.out.println("Slaying Dragon!");
	}
}
