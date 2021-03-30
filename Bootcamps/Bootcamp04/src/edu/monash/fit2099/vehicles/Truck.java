package edu.monash.fit2099.vehicles;

import java.util.Scanner;

public class Truck extends Vehicle{
    private int capacity;
    private int wheels;
    private String vId = getvId();

    public Truck(String newMaker, String newModel, int capacity, int wheels) {
        super(newMaker, newModel);
        this.capacity = capacity;
        this.wheels = wheels;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any number:");
        int number = Integer.parseInt(scanner.nextLine());
        vId = ("truck"+String.valueOf(nextID(number)));
        setvId(vId);
    }

    public Truck(String maker, String model, String vId, int capacity, int wheels) {
        super(maker, model, vId);
        this.capacity = capacity;
        this.wheels = wheels;
    }
}
