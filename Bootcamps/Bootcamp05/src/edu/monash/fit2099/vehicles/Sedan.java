package edu.monash.fit2099.vehicles;

import java.util.Scanner;

public class Sedan extends Vehicle {
    private int seats;
    private String vId = getvId();

    public Sedan(String newMaker, String newModel, int seats) {
        super(newMaker, newModel);
        setSeats(seats);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any number:");
        int number = Integer.parseInt(scanner.nextLine());
        vId = ("sedan"+String.valueOf(nextID(number)));
        setvId(vId);
    }

    public Sedan(String maker, String model, String vId, int seats) {
        super(maker, model, vId);
        this.seats = seats;
    }

    public boolean setSeats(int seats) {
        boolean isValid=false;
        if(seats>=4 && seats<=5){
            isValid=true;
            this.seats = seats;
        }
        return isValid;
    }
}
