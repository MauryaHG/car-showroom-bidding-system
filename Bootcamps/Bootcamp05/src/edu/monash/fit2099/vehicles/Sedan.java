package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.exceptions.VehicleException;

import java.util.Scanner;

/**
 * @author Maurya
 * @version 5.0.0
 * @see Vehicle
 */
public class Sedan extends Vehicle {
    /**
     * number of seats of sedan
     */
    private int seats;
    /**
     * vehicle id of sedan
     */
    private String vId = getvId();

    /**
     *
     * @param newMaker maker of sedan
     * @param newModel model of sedan
     * @param seats number of seats of sedan
     * @throws VehicleException
     */
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

    /**
     * -
     * @param maker maker of sedan
     * @param model model of sedan
     * @param vId vehicle id of sedan
     * @param seats number of seats of sedan
     * @throws VehicleException
     */
    public Sedan(String maker, String model, String vId, int seats) throws VehicleException {
        super(maker, model, vId);
        this.seats = seats;
    }

    /**
     * checks if number os seats have a valid value
     * @param seats number of seats of sedan
     * @return
     */
    public boolean setSeats(int seats) {
        boolean isValid=false;
        if(seats>=4 && seats<=5){
            isValid=true;
            this.seats = seats;
        }
        return isValid;
    }
}
