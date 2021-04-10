package edu.monash.fit2099.buyers;

/**
 * @author Maurya
 * @version 5.0.0
 */
public class Buyer {
    /**
     * buyer id
     */
    private String buyerId;
    /**
     * given name of buyer
     */
    private String givenName;
    /**
     * family name of buyer
     */
    private String familyName;

    /**
     * zero parameter constructor
     */
    public Buyer() {

    }

    /**
     * creates instance of Buyer object
     * @param givenName given name of buyer
     * @param familyName family name of buyer
     * @param buyerId buyer id
     * @return Buyer/null
     */
    public static Buyer getInstance(String givenName, String familyName, String buyerId){
        Buyer buyer = new Buyer();
        if(buyer.setFamilyName(familyName) && buyer.setGivenName(givenName)) {
            buyer.setBuyerId(buyerId);
            return buyer;
        } else {
            return null;
        }
    }

    /**
     *
     * @param buyerId buyer id
     */
    public Buyer(String buyerId) {

        this.buyerId = buyerId;
    }

    /**
     *
     * @param buyerId buyer id
     * @param givenName given name of buyer
     * @param familyName family name of buyer
     */
    private Buyer(String buyerId, String givenName, String familyName) {

        this.buyerId = buyerId;
        setGivenName(givenName);
        setFamilyName(familyName);
    }

    /**
     * returns if input data is valid
     * @param givenName given name of buyer
     * @return isValid boolean
     */
    public boolean setGivenName(String givenName) {
        boolean isValid=false;
        if(givenName.length()>=2 && givenName.length()<=15){
            isValid=true;
            this.givenName = givenName;
        }
        return isValid;
    }

    /**
     * returns if input data is valid
     * @param familyName given name of buyer
     * @return isValid boolean
     */
    public boolean setFamilyName(String familyName) {
        boolean isValid=false;
        if(familyName.length()>=2 && familyName.length()<=15){
            isValid=true;
            this.familyName = familyName;
        }
        return isValid;
    }

    /**
     *
     * @param buyerId buyer id
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * displays current buyer
     * @return string of buyer
     */
    public String description(){

        return (this.buyerId + "|" + this.givenName + "|" + this.familyName);
    }

    /**
     * displays buyer object
     * @return string of buyer
     */
    @Override
    public String toString() {
        return "Buyer{" +
                "buyerId='" + buyerId + '\'' +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}
