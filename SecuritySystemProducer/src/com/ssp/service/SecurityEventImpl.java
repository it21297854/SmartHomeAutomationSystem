package com.ssp.service;

import java.util.Scanner;

public class SecurityEventImpl implements SecurityEvent {
    
    private boolean doorLocked = true;
    private boolean motionDetected = false;
    private boolean securityCameraRecording = false;
    private boolean SafetyOn = false;
    
    @Override
    public void handleSecurityCameras() {
        // Simulate recording footage from security cameras
        System.out.println("Recording footage from security cameras...");
        securityCameraRecording = true;
    }

    @Override
    public void motionDetectors() {
        // Simulate motion detection
        System.out.println("Checking for motion...");
        motionDetected = true;
        if (motionDetected) {
            // If motion detected, prompt user to unlock the door
            promptToUnlockDoor();
        }
    }

    @Override
    public String receiveStatus() {
        // Simulate receiving security status
        System.out.println("Receiving security status...");
        String status = "Door locked: " + doorLocked + ", Motion detected: " + motionDetected + ", Security camera recording: " + securityCameraRecording;
        return status;
    }

    @Override
    public void doorLockService() {
        // Simulate controlling door locks
        if (doorLocked) {
            doorLocked = false;
        } else {
            System.out.println("Locking the door...");
            doorLocked = true;
            LockAllDoors();
        }
    }

    @Override
    public void LockAllDoors() {
        Scanner scanner = new Scanner(System.in);
        	System.out.println("Do you want to Lock all the doors? (yes/no)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                System.out.println("Closing all the doors...");
                turnOnOffCameras();
                // Simulate opening the door
            } else if (input.equalsIgnoreCase("no")) {
                System.out.println("Same as it is");
                // Simulate closing the door
            } else {
                System.out.println("Invalid input.");
            }
    }

    @Override
    public void turnOnOffCameras() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to turn on() all the cameras or Turn on and record(2)? (1/2)");
        int input = scanner.nextInt();
        if (input==1) {
            System.out.println("Turning on all the cameras...");
            securityCameraRecording = true;
        } else if (input==2) {
            System.out.println("Turning on all the cameras and start recording...");
            securityCameraRecording = false;
        } else {
            System.out.println("Invalid input.");
        }
    }
    
    private void promptToUnlockDoor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Motion detected! Do you want to unlock the door? (yes/no)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            doorLockService(); // Unlock the door
        } else {
            System.out.println("Door remains locked.");
        }
    }
}
