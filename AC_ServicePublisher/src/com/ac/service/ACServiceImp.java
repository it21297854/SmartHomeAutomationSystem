package com.ac.service;

import java.util.ArrayList;

public class ACServiceImp implements ACService {
	
	ArrayList<AC> list = new ArrayList<AC>();
	
	

	public ACServiceImp() {
		super();
		this.list.add(new AC(1));
		this.list.add(new AC(2));
	}

	@Override
	public void onAC(int id) {
		
		this.list.get(id).setIsOn(true);
		
	}

	@Override
	public void offAC(int id) {
		
		this.list.get(id).setIsOn(false);
		
	}

	@Override
	public void increaseTemperature(int id) {
		
		if(this.list.get(id).getIsOn()) {
			if(this.list.get(id).getTemperatureLevel() < 32) {
				this.list.get(id).setTemperatureLevel(this.list.get(id).getTemperatureLevel() + 1);
			}else {
				System.out.println("Temperature Level is already maximum");
			}
		}else {
			System.out.println("AC is off");
		}
		
	}

	@Override
	public void decreaseTemperature(int id) {
		
		if(this.list.get(id).getIsOn()) {
			if(this.list.get(id).getTemperatureLevel() > 12) {
				this.list.get(id).setTemperatureLevel(this.list.get(id).getTemperatureLevel() - 1);
			}else {
				System.out.println("Temperature Level is already maximum");
			}
		}else {
			System.out.println("AC is off");
		}
		
	}

	@Override
	public int getTemperature(int id) {
		
		return this.list.get(id).getTemperatureLevel();
		
	}

	@Override
	public void speed(int id) {
		if(this.list.get(id).getSpeed()) {
			this.list.get(id).setSpeed(false);
		}else {
			this.list.get(id).setSpeed(true);
		}
		
	}

	@Override
	public void swing(int id) {
		if(this.list.get(id).getSwing())
			this.list.get(id).setSwing(false);
		else
			this.list.get(id).setSwing(true);
	}

	@Override
	public Boolean getSpeed(int id) {
		// TODO Auto-generated method stub
		return this.list.get(id).getSpeed();
	}

	@Override
	public Boolean getSwing(int id) {
		// TODO Auto-generated method stub
		return this.list.get(id).getSwing();
	}

}
