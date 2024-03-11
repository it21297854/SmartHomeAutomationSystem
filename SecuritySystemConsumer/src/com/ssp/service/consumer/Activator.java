package com.ssp.service.consumer;

import com.ssp.service.SecurityEvent;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

    private BundleContext context;
    private ServiceReference<SecurityEvent> serviceReference;
    private SecurityEvent securityEventService;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Consumer Activator: Start");
        this.context = context;

        // Get reference to SecurityEvent service
        serviceReference = context.getServiceReference(SecurityEvent.class);
        if (serviceReference != null) {
            securityEventService = context.getService(serviceReference);
            if (securityEventService != null) {
                // Call methods on the SecurityEvent service
                securityEventService.handleSecurityCameras();
                securityEventService.motionDetectors();
                String status = securityEventService.receiveStatus();
                System.out.println("Security status: " + status);
                securityEventService.doorLockService(); // Unlock the front door
            } else {
                System.out.println("Failed to get SecurityEvent service.");
            }
        } else {
            System.out.println("SecurityEvent service reference is null.");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Consumer Activator: Stop");
        if (serviceReference != null) {
            context.ungetService(serviceReference);
        }
    }
}
