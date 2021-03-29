package edu.monash.fit2099.vehicles;

public class Truck extends Vehicle{
    private int capacity;
    private int wheels;

    public Truck(String newMaker, String newModel, int capacity, int wheels) {
        super(newMaker, newModel);
        this.capacity = capacity;
        this.wheels = wheels;
    }

    public Truck(String maker, String model, String vId, int capacity, int wheels) {
        super(maker, model, vId);
        this.capacity = capacity;
        this.wheels = wheels;
    }
}
