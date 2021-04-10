package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.exceptions.VehicleException;

import java.util.Scanner;
/**
 * @author Maurya
 * @version 5.0.0
 * @see Vehicle
 */
public class Truck extends Vehicle{
    /**
     * capacity of truck
     */
    private int capacity;
    /**
     * number of wheels on truck
     */
    private int wheels;
    /**
     * vehicle id of truck
     */
    private String vId = getvId();

    /**
     *
     * @param newMaker maker of truck
     * @param newModel model of truck
     * @param capacity capacity of truck
     * @param wheels number of wheels of truck
     * @throws VehicleException throws vehicle exception
     */
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

    /**
     *
     * @param maker maker of truck
     * @param model model of truck
     * @param vId vehicle id  of truck
     * @param capacity capacity of truck
     * @param wheels number of wheels of truck
     * @throws VehicleException throws vehicle exception
     */
    public Truck(String maker, String model, String vId, int capacity, int wheels) throws VehicleException {
        super(maker, model, vId);
        this.capacity = capacity;
        this.wheels = wheels;
    }
    /**
     *
     * @param capacity capacity of truck
     * @return isValid boolean value
     */
    public boolean setCapacity(int capacity) {
        boolean isValid=false;
        if(capacity>=1 && capacity<=15){
            isValid=true;
            this.capacity = capacity;
        }
        return isValid;
    }
    /**
     *
     * @param wheels number of wheels of truck
     * @return isValid boolean value
     */
    public boolean setWheels(int wheels) {
        boolean isValid=false;
        if(wheels>=4 && wheels<=16){
            isValid=true;
            this.wheels = wheels;
        }
        return isValid;
    }
}
