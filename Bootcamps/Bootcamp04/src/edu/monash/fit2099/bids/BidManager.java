package edu.monash.fit2099.bids;

import edu.monash.fit2099.AutoShowroom;
import edu.monash.fit2099.buyers.Buyer;

import java.util.ArrayList;
import java.util.HashMap;

public class BidManager {
    private ArrayList<Bid> bidArray = new ArrayList<>();
    public int bidCount = 0;
    HashMap<String,Bid> hashMap ;

    public BidManager() {
        hashMap = new HashMap<>();

    }

    public void addBid(String buyerId, int price, String date) {
        bidCount++;
        String bidId = String.valueOf(bidCount);
        System.out.println(AutoShowroom.buyerArray);
        Buyer buyer = new Buyer(buyerId);
        Bid bid = new Bid(bidId,buyer, price, date);
        hashMap.put(buyerId,bid);
    }
    public void description(){
        for (int i = 0; i < bidArray.size(); i++) {
          System.out.println(bidArray.get(i));
        }

    }
}
