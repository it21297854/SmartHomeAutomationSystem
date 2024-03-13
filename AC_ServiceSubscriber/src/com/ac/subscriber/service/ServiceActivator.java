package com.ac.subscriber.service;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.ac.service.ACService;

public class ServiceActivator implements BundleActivator {

	
	ServiceReference serviceReference;
	
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Start AC service subcriber");
		serviceReference = context.getServiceReference(ACService.class.getName());
		ACService acServicePublish = (ACService)context.getService(serviceReference);
		
		boolean flag = true;
		int opt;
		
		do {
			System.out.println("Select the AC");
			System.out.println("1. AC 1");
			System.out.println("2. AC 2");
			System.out.println("3. Exit");
			
			opt = sc.nextInt();
			
			switch(opt) {
			case 1: 
				System.out.println("===========AC 1 ============");
				ACOption(opt, acServicePublish);
				break;
			case 2:
				System.out.println("===========AC 2 ============");
				ACOption(opt, acServicePublish);
				break;
			case 3:
				System.out.println("Thank You");
				flag = false;
				break;
			default:
				System.out.println("Invalid Input");
				
			}
			
		}while(flag);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("System off");
		context.ungetService(serviceReference);
	}
	
	public void ACOption(int id, ACService acService) {
		int opt;
		boolean flag = true;
		
		do {
			System.out.println("Select the AC option");
			System.out.println("1. Turn On");
			System.out.println("2. Turn Off");
			System.out.println("3. Increase the temperature");
			System.out.println("4. Decrease the temperature");
			System.out.println("5. speed");
			System.out.println("6. swing");
			System.out.println("7. Exit");
			
			opt = sc.nextInt();
			
			switch(opt) {
			case 1:
				acService.onAC(id - 1);
				System.out.println("Turning on AC " + id);
				break;
			case 2:
				acService.offAC(id - 1);
				System.out.println("Turning off AC " + id);
				break;
			case 3:
				acService.increaseTemperature(id-1);
				System.out.println("AC Temperature is " + acService.getTemperature(id-1));
				break;
			case 4:
				acService.decreaseTemperature(id-1);
				System.out.println("AC Temperature is " + acService.getTemperature(id-1));
				break;
			case 5:
				acService.speed(id-1);
				if(acService.getSpeed(id-1))
					System.out.println("High Speed");
				else
					System.out.println("Low Speed");
				break;
			case 6: 
				acService.swing(id-1);
				if(acService.getSwing(id-1))
					System.out.println("Swinging");
				else
					System.out.println("fixed");
				break;
			case 7:
				System.out.println("==========================");
				flag = false;
			default:
				System.out.println("Invalid Input");
			}
			
			System.out.println();


		}while(flag);
		
	}

}
