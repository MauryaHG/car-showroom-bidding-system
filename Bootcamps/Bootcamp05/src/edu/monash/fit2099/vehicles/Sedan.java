package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.exceptions.VehicleException;

import java.util.Scanner;

public class Sedan extends Vehicle {
    private int seats;
    private String vId = getvId();

    public Sedan(String newMaker, String newModel, int seats) throws VehicleException {
        super(newMaker, newModel);

        if (setSeats(seats)) {
            this.seats = seats;
            int number = 1;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter any number:");
            try {
                number = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter integer");
            }
            vId = ("sedan" + String.valueOf(nextID(number)));
            setvId(vId);

        } else {
            throw new VehicleException("Incorrect Seat number");
        }
    }

    public Sedan(String maker, String model, String vId, int seats) throws VehicleException {
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
