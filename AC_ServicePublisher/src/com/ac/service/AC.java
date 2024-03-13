package com.ac.service;

public class AC {
	
	private int id;
	private Boolean isOn;
	private int temperatureLevel;
	private Boolean speed;
	private Boolean swing;
	
	public AC(int id) {
		super();
		this.id = id;
		this.isOn = false;
		this.temperatureLevel = 20;
		this.speed = true;
		this.swing = true;
	}
	
	

	public Boolean getSpeed() {
		return speed;
	}

	public void setSpeed(Boolean speed) {
		this.speed = speed;
	}

	public Boolean getSwing() {
		return swing;
	}

	public void setSwing(Boolean swing) {
		this.swing = swing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getIsOn() {
		return isOn;
	}

	public void setIsOn(Boolean isOn) {
		this.isOn = isOn;
	}

	public int getTemperatureLevel() {
		return temperatureLevel;
	}

	public void setTemperatureLevel(int temperatureLevel) {
		this.temperatureLevel = temperatureLevel;
	}
	
	

}
