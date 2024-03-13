package com.ac.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	
	ServiceRegistration acRegistration;
	

	public void start(BundleContext context) throws Exception {
		
		System.out.println("AC publisher start");
		ACService acService = new ACServiceImp();
		
		acRegistration = context.registerService(ACService.class.getName(), acService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("AC publish off");
		acRegistration.unregister();
		
	}

}
