package com.oca.p1;

public class Car implements Vehicle, Alarm {
 
    private String brand;
          
    public Car(String brand) {
		super();
		this.brand = brand;
	}

	@Override
    public String getBrand() {
        return brand;
    }
     
    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }
     
    @Override
    public String slowDown() {
        return "The car is slowing down.";
    }

	@Override
	public String turnAlarmOff() {
		return Vehicle.super.turnAlarmOff() + " " + Alarm.super.turnAlarmOff();
	}

	@Override
	public String turnAlarmOn() {
		return Vehicle.super.turnAlarmOn() + " " + Alarm.super.turnAlarmOn();
	}
	
	public String turnOff() {
		return "Turning the car off";
	}
}