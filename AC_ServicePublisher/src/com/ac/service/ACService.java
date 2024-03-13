package com.ac.service;

public interface ACService {
	
	public void onAC(int id);
	
	public void offAC(int id);
	
	public void increaseTemperature(int id);
	
	public void decreaseTemperature(int id);
	
	public void speed(int id);
	
	public void swing(int id);
	
	public int getTemperature(int id);
	
	public Boolean getSpeed(int id);
	
	public Boolean getSwing(int id);

}
