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
        setGivenName(givenName);
        setFamilyName(familyName);
    }

    public boolean setGivenName(String givenName) {
        boolean isValid=false;
        if(givenName.length()>=2 && givenName.length()<=15){
            isValid=true;
            this.givenName = givenName;
        }
        return isValid;
    }

    public boolean setFamilyName(String familyName) {
        boolean isValid=false;
        if(familyName.length()>=2 && familyName.length()<=15){
            isValid=true;
            this.familyName = familyName;
        }
        return isValid;
    }

    public String description(){

        return (this.buyerId + "|" + this.givenName + "|" + this.familyName);
    }

}
