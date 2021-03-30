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

    public void setvId(String vId) {
        this.vId = vId;
    }

    public String getvId() {

        return vId;
    }


    public BidManager getBids() {

        return bids;
    }

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

        return (this.getvId()+"|"+ this.maker + "|"+ this.model);

    }

    public int nextID(int number) {
        Random r = new Random();
        int low = number;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }
}
