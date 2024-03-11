package com.mtit.service;

public class Light {
	private int id;
	
	private boolean isOn = false;
	
	private int brightnessLevel = 0;
	
	public Light(int id) {
		this.id = id;
		this.brightnessLevel = 3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public int getBrightnessLevel() {
		return brightnessLevel;
	}

	public void setBrightnessLevel(int brightnessLevel) {
		if(brightnessLevel < 6 && brightnessLevel > 0) {
			this.brightnessLevel = brightnessLevel;			
		}
	}

}
