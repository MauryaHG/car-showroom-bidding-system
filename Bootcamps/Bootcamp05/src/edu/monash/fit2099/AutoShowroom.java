package edu.monash.fit2099;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.SedanException;
import edu.monash.fit2099.exceptions.TruckException;
import edu.monash.fit2099.exceptions.VehicleException;
import edu.monash.fit2099.vehicles.Sedan;
import edu.monash.fit2099.vehicles.Truck;
import edu.monash.fit2099.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class AutoShowroom {

    ArrayList<Vehicle> vehicleArray = new ArrayList();
    public static ArrayList<Buyer> buyerArray = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);




    public void printStatus() {
        createCars();
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
                    break;
            }
            System.out.println("--------------------------");
        }while (selection!=7);
        System.out.println("Thank you for visiting FIT2099 Showroom");
    }
    public int printMenu(){
        System.out.println("Welcome to FIT2099 Showroom");
        System.out.println("1) New Sedan");
        System.out.println("2) New Truck");
        System.out.println("3) Display Fleet");
        System.out.println("4) Add Buyer");
        System.out.println("5) List Buyers");
        System.out.println("6) Add bid");
        System.out.println("7) Exit");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
    public void createCars() {
        /*
        try {
            vehicleArray.add(new Sedan("BMW", "X7", "sedan1234", 6));
        }
        catch (VehicleException e){
            System.out.println(e.getMessage());
        }
        vehicleArray.add(new Truck("Audi", "A8","truck4564",10,6));
        vehicleArray.add(new Sedan("Mercedes", "GLS","sedan5678",4));


        buyerArray.add(new Buyer("AAAAA", "Issac", "Newton"));
        vehicleArray.get(0).addBid(buyerArray.get(0), 5000, "12/12/2020" );
        vehicleArray.get(0).addBid(buyerArray.get(1), 25000, "12/12/2021" );
        vehicleArray.get(1).addBid(buyerArray.get(2), 2000, "6/5/2021" );
        bidding();*/

    }

    public void displayCars(){
        /*for (int i = 0; i < vehicleArray.size(); i++) {

            System.out.println("Car (" +(i+1)+ ") " + vehicleArray.get(i).description());
            if (vehicleArray.get(i).bidCount > 0) {

                int bids = vehicleArray.get(i).bidCount;
                System.out.println("Car (" + (i + 1) + ") has " + bids + " bids");
                for (int j =0; j < bids; j++) {

                    Bid bidArray = (Bid) vehicleArray.get(i).getBids().get(j);
                    String buyer = bidArray.getBuyer().description();
                    System.out.println("edu.monash.fit2099.bids.Bid (" + (j + 1) + ") : " + bidArray.getBidId() + " " + buyer + " " + bidArray.getBidPrice() + " " + bidArray.getDate()) ;
                }
            } else{
                System.out.println("Car (" + (i + 1) + ") has 0 bids");
            }
        }*/
    }

    public void bidding(){
        /*for (int i = 0; i < vehicleArray.size(); i++) {

            System.out.println("Car (" + (i + 1) + ") " + vehicleArray.get(i).description());

            System.out.println("Enter 1 to bid or 0 to view next car");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice==1) {
                System.out.println("Enter Buyer First name");
                String firstName = scanner.nextLine();

                System.out.println("Enter Buyer Last name");
                String givenName = scanner.nextLine();

                System.out.println("Enter Buyer Id");
                String buyerId = scanner.nextLine();

                System.out.println("Enter Date");
                String date = scanner.nextLine();

                System.out.println("Enter Bid price");
                int bidPrice = Integer.parseInt(scanner.nextLine());

                buyerArray.add(new Buyer(buyerId, firstName, givenName));
                int buyer = buyerArray.size();
                vehicleArray.get(i).addBid(buyerArray.get(buyer - 1), bidPrice, date);
            }
            }*/
    }
    public void createSedan(){
        System.out.print("Enter sedan maker: ");
        String maker = scanner.nextLine();

        System.out.print("Enter sedan model:");
        String model = scanner.nextLine();

        System.out.print("Enter number of seats:");
        int numSeats = Integer.parseInt(scanner.nextLine());
        try {
            vehicleArray.add(new Sedan(maker,model,numSeats));
        }
        catch (SedanException e){
            System.out.println(e.getMessage());
        }
        catch (VehicleException e){
            System.out.println(e.getMessage());
        }

        System.out.println(vehicleArray.get(vehicleArray.size()-1).description());

    }
    public void createTruck(){
        System.out.print("Enter truck maker:");
        String maker = scanner.nextLine();

        System.out.print("Enter truck model:");
        String model = scanner.nextLine();

        System.out.print("Enter number of wheels:");
        int numWheels = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter truck capacity:");
        int capacity = Integer.parseInt(scanner.nextLine());

        try {
            vehicleArray.add(new Truck(maker,model,capacity,numWheels));
        }
        catch (TruckException e){
            System.out.println(e.getMessage());
        }
        catch (VehicleException e){
            System.out.println(e.getMessage());
        }

        System.out.println(vehicleArray.get(vehicleArray.size()-1).description());

    }
    public void createBuyer(){
        System.out.print("Enter Buyer First name:");
        String firstName = scanner.nextLine();

        System.out.print("Enter Buyer Last name:");
        String givenName = scanner.nextLine();

        System.out.print("Enter Buyer Id:");
        String buyerId = scanner.nextLine();

       // buyerArray.add(new Buyer(firstName,givenName,buyerId));
        Buyer buyer = Buyer.getInstance(givenName, firstName, buyerId);
        if (buyer != null) {
            buyerArray.add(buyer);
            System.out.println(buyer);
        } else
            System.out.println("Something wrong with the buyer's values!!!");
    }

    public void createBid(){

        System.out.print("Enter vehicle id:");
        String vehicleId = scanner.nextLine();

        System.out.print("Enter Buyer Id:");
        String buyerId = scanner.nextLine();

        System.out.print("Enter Date:");
        String date = scanner.nextLine();

        System.out.print("Enter Bid price:");
        int bidPrice = Integer.parseInt(scanner.nextLine());

        for (Vehicle vehicle : vehicleArray) {
            if (vehicle.getvId().equals(vehicleId)) {

                vehicle.getBids().addBid(buyerId, bidPrice, date);
            }
        }
    }

    public void displayFleet(){
        for (int i = 0; i < vehicleArray.size(); i++) {
            System.out.println("Car (" + (i + 1) + ") "+ vehicleArray.get(i).description());
            vehicleArray.get(i).getBids().description();
        }
    }
    public void displayBuyers(){
        for (int i = 0; i < buyerArray.size(); i++) {
            System.out.println("Buyer (" + (i + 1) + ") " + buyerArray.get(i).description());
        }
    }
}
