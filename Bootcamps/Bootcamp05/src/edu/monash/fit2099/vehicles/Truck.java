package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.exceptions.VehicleException;

import java.util.Scanner;

public class Truck extends Vehicle{
    private int capacity;
    private int wheels;
    private String vId = getvId();

    public Truck(String newMaker, String newModel, int capacity, int wheels) throws VehicleException {
        super(newMaker, newModel);

        if(setCapacity(capacity) && setWheels(wheels)) {
            Scanner scanner = new Scanner(System.in);
            int number=1;
            System.out.print("Enter any number:");
            try {
                number = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Enter integer value");
            }
            vId = ("truck" + String.valueOf(nextID(number)));
            setvId(vId);
        } else {
            throw new VehicleException("Incorrect Capacity or Wheel number");
        }
    }

    public Truck(String maker, String model, String vId, int capacity, int wheels) throws VehicleException {
        super(maker, model, vId);
        this.capacity = capacity;
        this.wheels = wheels;
    }

    public boolean setCapacity(int capacity) {
        boolean isValid=false;
        if(capacity>=1 && capacity<=15){
            isValid=true;
            this.capacity = capacity;
        }
        return isValid;
    }

    public boolean setWheels(int wheels) {
        boolean isValid=false;
        if(wheels>=4 && wheels<=16){
            isValid=true;
            this.wheels = wheels;
        }
        return isValid;
    }
}
