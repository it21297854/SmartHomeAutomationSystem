 package osgi_servicesubscriber;



import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.service.ILightService;

public class ServiceActivator implements BundleActivator {
	
	ServiceReference serviceReference;
	
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {
		
		
		
		
		System.out.println("start subscriber service");
		serviceReference = context.getServiceReference(ILightService.class.getName());
		
		ILightService lightServicePublish = (ILightService) context.getService(serviceReference);
		
		System.out.println("Welcome to light automation system");
		
		
		boolean exit = false;
		do {
			
			System.out.println("Select whick light to manipulate: ");
			System.out.println("1. Light 1");
			System.out.println("2. Light 2");
			System.out.println("3. Light 3");
			System.out.println("4. exit");
			
			int id = sc.nextInt();
			
			switch (id) {
			case 1:
				System.out.println("========= The Light 1 =======");
				lightServices(id - 1, lightServicePublish);
				break;

			case 2:
				System.out.println("========= The Light 2 =======");
				lightServices(id - 1, lightServicePublish);
				break;

			case 3:
				System.out.println("========= The Light 3 =======");
				lightServices(id - 1, lightServicePublish);
				break;

			case 4:
				exit = true;
				System.out.println("Thank you!!");
				System.out.println("===========================================");
				break;

			default:
				System.out.println("please select correct option!!!");
				break;

			}
		} while (!exit);
		
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye");
		context.ungetService(serviceReference);
	}
	
	public void lightServices(int id, ILightService lightServicePublish) {
		int value;
		boolean exit = false;
		
		do {
			System.out.println("What do you want to perform on your light " + (id + 1) + " (please pick a choice): ");
			System.out.println("1. Turn on the light");
			System.out.println("2. Turn off the light");
			System.out.println("3. Increase the brightness");
			System.out.println("4. Decrease the brightness");
			System.out.println("5. Exit");
			value = sc.nextInt();
			switch (value) {
			case 1:
				lightServicePublish.on(id);
				System.out.println("The light " + (id + 1) + " is turning on...");
				System.out.println("The brightness level is " + lightServicePublish.getBrightness(id));
				break;
			case 2:
				lightServicePublish.off(id);
				System.out.println("The light " + (id + 1) + " is turning off...");
				break;
			case 3:
				lightServicePublish.increaseBrightness(id);
				System.out.println("The brightness level is " + lightServicePublish.getBrightness(id));
				break;
			case 4:
				lightServicePublish.decreaseBrightness(id);
				System.out.println("The brightness level is " + lightServicePublish.getBrightness(id));
				
				break;
			case 5:
				exit = true;
				
				System.out.println("Thank you!!");
				System.out.println("===========================================");
				break;
			default:
				System.out.println("Please select correct option!!!");
				break;
			}
		} while (!exit);
	}

}
