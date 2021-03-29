import java.util.ArrayList;
import java.util.Scanner;

public class AutoShowroom {

    ArrayList<Vehicle> vehicleArray = new ArrayList();
    ArrayList<Buyer> buyerArray = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void printStatus() {
        System.out.println("Welcome to FIT2099 Showroom");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");
    }

    public void createCars() {
        vehicleArray.add(new Sedan("BMW", "X7"));
        vehicleArray.add(new Truck("Audi", "A8"));
        vehicleArray.add(new Sedan("Mercedes", "GLS"));


        buyerArray.add(new Buyer("AAAAA", "Issac", "Newton"));
        buyerArray.add(new Buyer("AAAAB", "Keanu", "Revees"));
        buyerArray.add(new Buyer("AAAAC", "Jhon", "Cena"));
        vehicleArray.get(0).addBid(buyerArray.get(0), 5000, "12/12/2020" );
        vehicleArray.get(0).addBid(buyerArray.get(1), 25000, "12/12/2021" );
        vehicleArray.get(1).addBid(buyerArray.get(2), 2000, "6/5/2021" );
        bidding();

    }

    public void displayCars(){
        for (int i = 0; i < vehicleArray.size(); i++) {

            System.out.println("Car (" +(i+1)+ ") " + vehicleArray.get(i).description());
            if (vehicleArray.get(i).bidCount > 0) {

                int bids = vehicleArray.get(i).bidCount;
                System.out.println("Car (" + (i + 1) + ") has " + bids + " bids");
                for (int j =0; j < bids; j++) {

                    Bid bidArray = (Bid) vehicleArray.get(i).bids.get(j);
                    String buyer = bidArray.getBuyer().description();
                    System.out.println("Bid (" + (j + 1) + ") : " + bidArray.getBidId() + " " + buyer + " " + bidArray.getBidPrice() + " " + bidArray.getDate()) ;
                }
            } else{
                System.out.println("Car (" + (i + 1) + ") has 0 bids");
            }
        }
    }

    public void bidding(){
        for (int i = 0; i < vehicleArray.size(); i++) {

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
            }
        }
}