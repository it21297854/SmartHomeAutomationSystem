package com.mtit.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {
	
	ServiceRegistration lightServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("light publisher start");
		ILightService lightService = new ILightServiceImpl();
		
		lightServiceRegistration = context
				.registerService(ILightService.class.getName(), lightService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("light publisher stop");
		
		lightServiceRegistration.unregister();
	}

}
