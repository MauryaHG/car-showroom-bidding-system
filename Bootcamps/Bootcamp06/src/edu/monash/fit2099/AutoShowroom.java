package edu.monash.fit2099;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.SedanException;
import edu.monash.fit2099.exceptions.TruckException;
import edu.monash.fit2099.exceptions.VehicleException;
import edu.monash.fit2099.vehicles.Sedan;
import edu.monash.fit2099.vehicles.Truck;
import edu.monash.fit2099.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Maurya
 * @version 5.0.0
 * @see Vehicle
 * @see Buyer
 *
 */
public class AutoShowroom {
    /**
     * array of all the vehicles in showroom
     */
    ArrayList<Vehicle> vehicleArray = new ArrayList();
    /**
     * array of all the buyers
     */
    public static ArrayList<Buyer> buyerArray = new ArrayList<>();
    /**
     * creates new scanner instance
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * This method takes the users input and calls the relavent method
     */
    public void printStatus() {
        addData();
        /**
         * selection option chosen by user
         */
        int selection;
        do {
            selection= printMenu();
            switch (selection) {
                case 1:
                    createSedan();
                    break;
                case 2:
                    createTruck();
                    break;
                case 3:
                    displayFleet();
                    break;
                case 4:
                    createBuyer();
                    break;
                case 5:
                    displayBuyers();
                    break;
                case 6:
                    createBid();
                    break;
                case 7:
                    displayMaxBid();
                    break;
                case 8:
                    displayMinBid();
                    break;
                case 9:
                    break;
            }
            System.out.println("--------------------------");
        }while (selection!=9);
        System.out.println("Thank you for visiting FIT2099 Showroom");
    }

    /**
     * Prints out instructions for user to follow
     * @return choice integer entered by user
     */
    public int printMenu(){
        System.out.println("Welcome to FIT2099 Showroom");
        System.out.println("1) New Sedan");
        System.out.println("2) New Truck");
        System.out.println("3) Display Fleet");
        System.out.println("4) Add Buyer");
        System.out.println("5) List Buyers");
        System.out.println("6) Add bid");
        System.out.println("7) Display Best Bids");
        System.out.println("8) Display Worst Bids");
        System.out.println("9) Exit");
        System.out.print("Select an option: ");
        /**
         * option chosen by user
         */
        int choice =0;
        boolean isOk = false;
        while(!isOk){
            try {
                choice = scanner.nextInt();
                isOk = true;
            }catch (InputMismatchException e){
                System.out.println("Enter integer from 1-9");
            }
            scanner.nextLine();
        }
        return choice;
    }

    /**
     * creates a new sedan using user input
     * @exception NumberFormatException if integer value is not entered
     */
    public void createSedan(){
        System.out.print("Enter sedan maker: ");
        /**
         * maker entered by user
         */
        String maker = scanner.nextLine();

        System.out.print("Enter sedan model:");
        /**
         * model entered by user
         */
        String model = scanner.nextLine();

        System.out.print("Enter number of seats:");
        /**
         * number of seats entered by user
         */
        int numSeats =0;
        try {
            numSeats = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Enter Integer");
        }

        try {
            vehicleArray.add(new Sedan(maker,model,numSeats));
            System.out.println(vehicleArray.get(vehicleArray.size()-1).description());
        }
        catch (SedanException e){
            System.out.println(e.getMessage());
        }
        catch (VehicleException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * creates a new truck using user input
     * @exception NumberFormatException if integer value is not entered
     */
    public void createTruck(){
        System.out.print("Enter truck maker:");
        /**
         * maker entered by user
         */
        String maker = scanner.nextLine();

        System.out.print("Enter truck model:");
        /**
         * model entered by user
         */
        String model = scanner.nextLine();

        System.out.print("Enter number of wheels:");
        /**
         * number of wheels entered by user
         */
        int numWheels;
        try {
            numWheels = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            System.out.println("Enter integer");
            return;
        }

        System.out.print("Enter truck capacity:");
        /**
         * capacity of truck entered by user
         */
        int capacity;
        try {
            capacity = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Input integer");
            return;
        }

        try {
            vehicleArray.add(new Truck(maker,model,capacity,numWheels));
            System.out.println(vehicleArray.get(vehicleArray.size()-1).description());
        }
        catch (TruckException e){
            System.out.println(e.getMessage());
        }
        catch (VehicleException e){
            System.out.println(e.getMessage());
        }



    }
    /**
     * creates a new buyer using user input
     */
    public void createBuyer(){
        System.out.print("Enter Buyer First name:");
        /**
         * first name entered of user
         */
        String firstName = scanner.nextLine();

        System.out.print("Enter Buyer Last name:");
        /**
         * given name entered of user
         */
        String givenName = scanner.nextLine();

        System.out.print("Enter Buyer Id:");
        /**
         * buyer ID  of user
         */
        String buyerId = scanner.nextLine();

        Buyer buyer = Buyer.getInstance(firstName,givenName , buyerId);
        if (buyer != null) {
            buyerArray.add(buyer);
            System.out.println(buyer);
        } else
            System.out.println("Something wrong with the buyer's values!!!");
    }

    /**
     * creates a new BID using user input
     * @exception NumberFormatException if integer value is not entered
     */
    public void createBid(){

        System.out.print("Enter vehicle id:");
        /**
         * Vehicle id of the  vehicle
         */
        String vehicleId = scanner.nextLine();

        System.out.print("Enter Buyer Id:");
        /**
         * buyer ID of the user
         */
        String buyerId = scanner.nextLine();

        System.out.print("Enter Date:");
        /**
         * date of bid
         */
        String date = scanner.nextLine();

        System.out.print("Enter Bid price:");
        /**
         * Price of the bid
         */
        int bidPrice = 0;
        try {
            bidPrice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Enter Integer value");
        }


        for (Vehicle vehicle : vehicleArray) {
            if (vehicle.getvId().equals(vehicleId)) {
                    vehicle.getBids().addBid(buyerId, bidPrice, date);
            }
        }
    }
    /**
     * displays all the cars in vehicleArray
     */
    public void displayFleet(){
        for (int i = 0; i < vehicleArray.size(); i++) {
            System.out.println("Car (" + (i + 1) + ") "+ vehicleArray.get(i).description());
            vehicleArray.get(i).getBids().description();
        }
    }

    /**
     * displays all there buyers
     */
    public void displayBuyers(){
        for (int i = 0; i < buyerArray.size(); i++) {
            System.out.println("Buyer (" + (i + 1) + ") " + buyerArray.get(i).description());
        }
    }


    public void displayMaxBid(){
        for (int i = 0; i < vehicleArray.size(); i++) {
            System.out.println("Car (" + (i + 1) + ") "+ vehicleArray.get(i).description());
            vehicleArray.get(i).getBids().maxBid();
        }
    }

    public void displayMinBid(){
        for (int i = 0; i < vehicleArray.size(); i++) {
            System.out.println("Car (" + (i + 1) + ") "+ vehicleArray.get(i).description());
            vehicleArray.get(i).getBids().minBid();
        }
    }


    public void addData() {
        try {
            vehicleArray.add(new Sedan("BMW", "X7","sedan1234",5));
            vehicleArray.add(new Truck("Audi", "A8","truck4564",10,6));
            vehicleArray.add(new Sedan("Mercedes", "GLS","sedan5678",4));
        }
        catch (SedanException e){
            System.out.println(e.getMessage());
        }
        catch (VehicleException e){
            System.out.println(e.getMessage());
        }


        buyerArray.add(Buyer.getInstance("Newton", "Issac", "22"));
        buyerArray.add(Buyer.getInstance("jake", "paul", "55"));
        vehicleArray.get(0).getBids().addBid("55", 5000, "12/12/2020" );
        vehicleArray.get(0).getBids().addBid("22", 251, "12/12/2021");
       // vehicleArray.get(2).getBids().addBid("sedan1234", 2000, "6/5/2021");

    }
}
