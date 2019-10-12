package com.oca.p1;

public interface Vehicle {
     
    String getBrand();
     
    String speedUp();
     
    String slowDown();
     
    default String turnAlarmOn() {
        return "Turning the vehicle alarm on.";
    }
     
    default String turnAlarmOff() {
        return "Turning the vehicle alarm off.";
    }
    
    default String turnOn() {
    	return "Turning the vehicule on.";
    }
    
    static int getHorsePower(int rpm, int torque) {
        return (rpm * torque) / 5252;
    }
}