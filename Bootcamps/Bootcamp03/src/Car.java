import java.util.ArrayList;

public class Car {
    public String make;
    public String model;
    public ArrayList bids = new ArrayList();
    public int bidCount = 0;

    public Car(String newMake, String newModel){
        make = newMake;
        model = newModel;
    }
    public String description(){

        return ("Maker: "+ make + " and Model: "+ model);
    }

    public void addBid(Buyer newBuyer, int price, String date){
        bidCount++;
        String bidId = String.valueOf(bidCount);
        bids.add(new Bid(bidId, newBuyer, price, date));
    }
}
