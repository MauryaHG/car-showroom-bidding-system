package edu.monash.fit2099.buyers;

public class Buyer {

    private String buyerId;
    private String givenName;
    private String familyName;

    public Buyer(String buyerId) {

        this.buyerId = buyerId;
    }

    public Buyer(String buyerId, String givenName, String familyName) {

        this.buyerId = buyerId;
        this.givenName = givenName;
        this.familyName = familyName;
    }

    public void setGivenName(String givenName) {

        this.givenName = givenName;
    }

    public void setFamilyName(String familyName) {

        this.familyName = familyName;
    }

    public String description(){

        return (buyerId + " " + givenName + " " + familyName);
    }

}
