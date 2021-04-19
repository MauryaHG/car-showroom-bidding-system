package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.bids.BidManager;
import edu.monash.fit2099.exceptions.VehicleException;

import java.util.Random;

/**
 * @author Maurya
 * @version 5.0.0
 * @see BidManager
 */
abstract public class Vehicle {
    /**
     * maker of vehicle
     */
    private String maker;
    /**
     * model of vehicle
     */
    private String model;
    /**
     * id of vehicle
     */
    private String vId;
    /**
     * BidManager instance
     */
    private BidManager bids = new BidManager();
    /**
     * number of bids
     */
    public int bidCount = 0;



    /**
     * sets vehicle id
     * @param vId vehicle id
     */
    public void setvId(String vId) {
        this.vId = vId;
    }

    /**
     * gets vehicle id
     * @return vId vehicle id
     */
    public String getvId() {

        return vId;
    }

    /**
     * gets BidManager object
     * @return bids
     */
    public BidManager getBids() {
        return bids;
    }
    /**
     * @param maker maker of vehicle
     * @param model model of vehicle
     * @throws VehicleException throws vehicle exception
     */
    public Vehicle(String maker, String model) throws VehicleException {
        if (setMaker(maker) && setModel(model)) {
        } else {
            throw new VehicleException("Incorrect Maker OR Model");
        }

    }
    /**
     * @param maker maker of vehicle
     * @param model model of vehicle
     * @param vId vehicle id of vehicle
     * @throws VehicleException throws vehicle exception
     */
    public Vehicle(String maker, String model, String vId) throws VehicleException{
        if (setMaker(maker) && setModel(model)) {
            this.vId = vId;
        } else {
            throw new VehicleException("Incorrect Maker OR Model");
        }

    }

    /**
     * displays vehicle added
     * @return string of vehicle
     */
    public String description(){

        return (this.getvId()+"|"+ this.maker + "|"+ this.model);

    }

    /**
     * creates random vehicle id
     * @param number any number entered by user
     * @return random integer
     */
    public int nextID(int number) {
        Random r = new Random();
        int low = number;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    /**
     *
     * @param maker maker of vehicle
     * @return isValid boolean value
     */
    public boolean setMaker(String maker) {
        boolean isValid=false;
        if(maker.length()>=3 && maker.length()<=15){
            isValid=true;
            this.maker = maker;
        }
        return isValid;
    }
    /**
     *
     * @param model maker of vehicle
     * @return isValid boolean value
     */
    public boolean setModel(String model) {
        boolean isValid=false;
        if(model.length()>=2 && model.length()<=15){
            isValid=true;
            this.model = model;
        }
        return isValid;
    }
}
