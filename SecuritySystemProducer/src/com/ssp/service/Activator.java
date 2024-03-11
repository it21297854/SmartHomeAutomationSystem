package com.ssp.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration serviceRegistration;
	
	@Override
	public void start(BundleContext bundleContext‎) throws Exception {
		System.out.println("Security System Producer Activator: Start");
		Activator.context = bundleContext‎;
		SecurityEvent securityEvent = new SecurityEventImpl();
		serviceRegistration = bundleContext‎.registerService(SecurityEvent.class.getName(), securityEvent, null);
		
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Security System Producer Activator: Stop");
		serviceRegistration.unregister();
	}

}
