package edu.monash.fit2099.vehicles;

import java.util.Scanner;

public class Sedan extends Vehicle {
    private int seats;
    private String vId;

    public Sedan(String newMaker, String newModel, int seats) {
        super(newMaker, newModel);
        this.seats = seats;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any number");
        int number = Integer.parseInt(scanner.nextLine());
        vId = String.valueOf(nextID(number));
    }

    public Sedan(String maker, String model, String vId, int seats) {
        super(maker, model, vId);
        this.seats = seats;
    }
}
