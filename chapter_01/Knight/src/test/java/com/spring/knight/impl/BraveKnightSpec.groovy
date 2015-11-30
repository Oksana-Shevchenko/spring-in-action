package com.spring.knight.impl

import com.spring.quest.IQuest;

import spock.lang.Specification
import spock.lang.Unroll
import spock.lang.Subject


class BraveKnightSpec extends Specification {
	
	@Subject
	BraveKnight braveKnight
	

	IQuest quest = Mock()
	
	def setup(){
		braveKnight = new BraveKnight(quest)
	}
	
	def "embark on quest"(){
		when:
		braveKnight.embarkOnQuest()
		then:
		1* quest.embark()
	}
}
