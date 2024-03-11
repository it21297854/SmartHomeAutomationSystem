package com.ssp.service;

public interface SecurityEvent {
	public void handleSecurityCameras();
    public void doorLockService();
    public void motionDetectors();
    public String receiveStatus();
    public void LockAllDoors();
    public void turnOnOffCameras();

}
