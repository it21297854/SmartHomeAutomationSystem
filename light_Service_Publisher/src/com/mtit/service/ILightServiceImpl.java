package com.mtit.service;

import java.util.ArrayList;

public class ILightServiceImpl implements ILightService {
	
	Light light = new Light(1);
//	Light light = new Light(2);
	ArrayList<Light> list = new ArrayList<>();
	
	public ILightServiceImpl() {
		list.add(light);
		list.add(new Light(2));
		list.add(new Light(3));
	}
	

	@Override
	public void on(int id) {
		list.get(id).setOn(true);
	}

	@Override
	public void off(int id) {
		list.get(id).setOn(false);
	}

	@Override
	public void increaseBrightness(int id) {
		if(list.get(id).isOn()) {			
			if(list.get(id).getBrightnessLevel() < 5) {
				list.get(id).setBrightnessLevel(list.get(id).getBrightnessLevel() + 1);
			}else {
				System.out.println("The light is in full brightness");
			}
		}else {
			System.out.println("The light is off");
			
		}
	}

	@Override
	public void decreaseBrightness(int id) {
		if(list.get(id).isOn()) {			
			if(list.get(id).getBrightnessLevel() > 1) {
				list.get(id).setBrightnessLevel(list.get(id).getBrightnessLevel() - 1);
			}else {
				System.out.println("The light is in least brightness");
			}
		}else {
			System.out.println("The light is off");
			
		}
	}

	@Override
	public int getBrightness(int id) {
		
		return list.get(id).getBrightnessLevel();
	}

}
