import java.util.ArrayList;
import java.util.Scanner;

public class AutoShowroom {

    ArrayList<Car> carArray = new ArrayList();
    ArrayList<Buyer> buyerArray = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void printStatus() {
        System.out.println("Welcome to FIT2099 Showroom");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");
    }

    public void createCars() {
        carArray.add(new Car("BMW", "X7"));
        carArray.add(new Car("Audi", "A8"));
        carArray.add(new Car("Mercedes", "GLS"));


        buyerArray.add(new Buyer("AAAAA", "Issac", "Newton"));
        buyerArray.add(new Buyer("AAAAB", "Keanu", "Revees"));
        buyerArray.add(new Buyer("AAAAC", "Jhon", "Cena"));
        carArray.get(0).addBid(buyerArray.get(0), 5000, "12/12/2020" );
        carArray.get(0).addBid(buyerArray.get(1), 25000, "12/12/2021" );
        carArray.get(1).addBid(buyerArray.get(2), 2000, "6/5/2021" );

        System.out.println("Enter Buyer First name");
        String firstName = scanner.nextLine();

        System.out.println("Enter Buyer Last name");
        String givenName = scanner.nextLine();

        System.out.println("Enter Buyer Id");
        String buyerId = scanner.nextLine();

        System.out.println("Enter Date");
        String date = scanner.nextLine();

        System.out.println("Enter Bid price");
        int bidPrice = scanner.nextInt();

        buyerArray.add(new Buyer(buyerId, firstName, givenName));
        carArray.get(2).addBid(buyerArray.get(3), bidPrice, date );

    }

    public void displayCars(){
        for (int i =0; i < carArray.size(); i++) {

            System.out.println("Car (" +(i+1)+ ") " +carArray.get(i).description());
            if (carArray.get(i).bidCount > 0) {

                int bids = carArray.get(i).bidCount;
                System.out.println("Car (" + (i + 1) + ") has " + bids + " bids");
                for (int j =0; j < bids; j++) {

                    Bid bidArray = (Bid) carArray.get(i).bids.get(j);
                    String buyer = bidArray.getBuyer().description();
                    System.out.println("Bid (" + (j + 1) + ") : " + bidArray.getBidId() + " " + buyer + " " + bidArray.getBidPrice() + " " + bidArray.getDate()) ;
                }
            } else{
                System.out.println("Car (" + (i + 1) + ") has 0 bids");
            }
        }
    }
}