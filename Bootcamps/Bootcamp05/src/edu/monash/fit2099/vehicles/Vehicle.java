package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.bids.BidManager;

import java.util.Random;

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
        setMaker(maker);
        setModel(model);

    }

    public Vehicle(String maker, String model, String vId) {
        setMaker(maker);
        setModel(model);
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

    public boolean setMaker(String maker) {
        boolean isValid=false;
        if(maker.length()>=3 && maker.length()<=15){
            isValid=true;
            this.maker = maker;
        }
        return isValid;
    }

    public boolean setModel(String model) {
        boolean isValid=false;
        if(model.length()>=3 && model.length()<=15){
            isValid=true;
            this.model = model;
        }
        return isValid;
    }
}
