package com.spring.componentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.spring.instrument.IInstrument;
import com.spring.performer.IPerformer;
@Component("eddie")
public class Instrumentalist implements IPerformer {
	@Value("Happy happy")
	private String song;
	@Autowired
	@Qualifier("guitarComponentScan")
	private IInstrument instrument;
	
	public Instrumentalist() {}

	public void perform() throws PerformerException {
		System.out.println("Playing: "+song+ " : ");
		instrument.play();
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

	public void setInstrument(IInstrument instrument) {
		this.instrument = instrument;
	}
	
	public IInstrument getInstrument() {
		return instrument;
	}
}
