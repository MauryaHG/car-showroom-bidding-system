package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Maurya
 * @version 1.0.0
 * @see Bid
 * @see Buyer
 *
 */
public class BidManager {
    /**
     * number of bids
     */
    public int bidCount = 0;
    /**
     * hashmap of bid and buyer
     */
    HashMap<String,Bid> hashMap ;

    /**
     * creates new hashmap instance
     */
    public BidManager() {
        hashMap = new HashMap<>();

    }

    /**
     * creates a bid and adds to hashmap
     * @param buyerId buyer id of current bid
     * @param price price of current bid
     * @param date date of current bid
     */
    public void addBid(String buyerId, int price, String date) {
        bidCount++;
        String bidId = String.valueOf(bidCount);
        Buyer buyer = new Buyer(buyerId);
        try {
            Bid bid = new Bid(bidId, price, date);
            hashMap.put(buyerId, bid);
        }
        catch (BidException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * displays the bids
     */
    public void description(){
        for (String key: hashMap.keySet()) {
          Bid tempBid = hashMap.get(key);
            System.out.println(" { Bid Id= "+tempBid.getBidId()
                                + ", Buyer Id=" + key
                                + ", Price= " + tempBid.getBidPrice()
                                + ", Date= " + tempBid.getDate() +"}"
            );
        }

    }

    public void maxBid() {
        ArrayList<Map.Entry<String, Bid>> bids = new ArrayList<>(hashMap.entrySet());
        if (bids.size() > 0){
            Map.Entry<String, Bid> maxBid = bids.get(0);
            for (int i = 1; i < bids.size(); i++) {
                Map.Entry<String, Bid> nextBid = bids.get(i);
                if (maxBid.getValue().getBidPrice() < nextBid.getValue().getBidPrice()) {
                    maxBid = nextBid;
                }
            }
            System.out.println("Best Bid: { Bid Id= " + maxBid.getValue().getBidId()
                    + ", Buyer Id=" + maxBid.getKey()
                    + ", Price= " + maxBid.getValue().getBidPrice()
                    + ", Date= " + maxBid.getValue().getDate() + "}"
            );

        }

    }

    public void minBid() {
        ArrayList<Map.Entry<String, Bid>> bids = new ArrayList<>(hashMap.entrySet());
        if (bids.size() > 0){
            Map.Entry<String, Bid> minBid = bids.get(0);
            for (int i = 1; i < bids.size(); i++) {
                Map.Entry<String, Bid> nextBid = bids.get(i);
                if (minBid.getValue().getBidPrice() > nextBid.getValue().getBidPrice()) {
                    minBid = nextBid;
                }
            }
            System.out.println("Worst Bid: { Bid Id= " + minBid.getValue().getBidId()
                    + ", Buyer Id=" + minBid.getKey()
                    + ", Price= " + minBid.getValue().getBidPrice()
                    + ", Date= " + minBid.getValue().getDate() + "}"
            );
        }

    }
    public void deleteBid(String bidId){
        String toRemove = "";
        for (String key: hashMap.keySet()) {
            if (hashMap.get(key).getBidId().equals(bidId)){
                toRemove = key;

            }
        }
        hashMap.remove(toRemove);

    }
}
