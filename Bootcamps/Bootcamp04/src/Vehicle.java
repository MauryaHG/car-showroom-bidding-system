import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract public class Vehicle {
    private String maker;
    private String model;
    private int vId;
    public ArrayList bids = new ArrayList(); //private
    public int bidCount = 0;

    public Vehicle(String maker, String model){
        this.maker = maker;
        this.model = model;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any number");
        int number = Integer.parseInt(scanner.nextLine());
        vId = nextID(number);
    }

    public Vehicle(String maker, String model, int vId) {
        this.maker = maker;
        this.model = model;
        this.vId = vId;
    }

    public String description(){

        return ("Maker: "+ this.maker + " and Model: "+ this.model);
    }

    public void addBid(Buyer newBuyer, int price, String date){
        bidCount++;
        String bidId = String.valueOf(bidCount);
        bids.add(new Bid(bidId, newBuyer, price, date));
    }

    public int nextID(int number) {
        Random r = new Random();
        int low = number;//using literal values is not a good idea, replace them with input parameters
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }
}
