package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.bids.Bid;
import edu.monash.fit2099.bids.BidManager;
import edu.monash.fit2099.buyers.Buyer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract public class Vehicle {
    private String maker;
    private String model;
    private String vId;
    private BidManager bids = new BidManager();

    public int bidCount = 0;

    public Vehicle(String maker, String model){
        this.maker = maker;
        this.model = model;

    }

    public Vehicle(String maker, String model, String vId) {
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
        int low = number;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    public ArrayList getBids() {

        return bids;
    }
}
