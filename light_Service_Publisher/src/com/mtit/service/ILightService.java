package com.mtit.service;

public interface ILightService {
	public void on(int id);
	
	public void off(int id);
	
	public void increaseBrightness(int id);
	
	public void decreaseBrightness(int id);
	
	public int getBrightness(int id);

}
