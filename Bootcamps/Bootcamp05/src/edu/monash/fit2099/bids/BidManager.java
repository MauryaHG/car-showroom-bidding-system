package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Maurya
 * @version 1.0.0
 * @see Bid
 * @see Buyer
 *
 */
public class BidManager {
    private ArrayList<Bid> bidArray = new ArrayList<>();
    public int bidCount = 0;
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
            Bid bid = new Bid(bidId, buyer, price, date);
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
}
