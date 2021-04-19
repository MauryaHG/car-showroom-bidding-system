package edu.monash.fit2099.bids;

import edu.monash.fit2099.exceptions.BidException;

import java.util.StringTokenizer;

/**
 * @author Maurya
 * @version 5.0.0
 * @see BidManager
 *
 */
public class Bid {
    /**
     * Id of the bid
     */
    private String bidId;
    /**
     * price of the bid
     */
    private int bidPrice;
    /**
     * date of the bid
     */
    private String date;

    /**
     * @param bidId id of the bid
     * @param bidPrice price of the bid
     * @param date date of the bid
     * @throws BidException throws bid exception
     */
    public Bid(String bidId, int bidPrice, String date) throws BidException {
        if(setBidPrice(bidPrice) && setDate(date)) {
            this.bidId = bidId;
        } else {
            throw new BidException("Bid information incorrect!!");
        }
    }
    /**
     * gets bid id of current instance
     * @return bidId
     */
    public String getBidId() {

        return bidId;
    }
    /**
     * sets bid id of current instance
     * @param bidId id of current bid
     */
    public void setBidId(String bidId) {

        this.bidId = bidId;
    }
    /**
     * gets bid price of current instance
     * @return bidPrice
     */
    public int getBidPrice() {

        return bidPrice;
    }
    /**
     * sets bid price of current instance
     * @param bidPrice price of current bid
     * @return isValid boolean if bid price is valid
     */
    public boolean setBidPrice(int bidPrice) {
        boolean isValid=false;
        if(bidPrice>=0){
            isValid=true;
            this.bidPrice = bidPrice;
        }
        return isValid;

    }
    /**
     * gets date of current instance
     * @return date
     */
    public String getDate() {

        return date;
    }

    /**
     * sets date of current instance
     * @param date date of current bid
     * @return isValid  boolean is date is valid
     */
    public boolean setDate(String date) {
        boolean isValid=false;
        StringTokenizer stt = new StringTokenizer(date, "/");
        int day,month,year;

        day = Integer.parseInt(stt.nextToken());
        month = Integer.parseInt(stt.nextToken());
        year = Integer.parseInt(stt.nextToken());

        if(day>=1 && day<=31 && month>=1 && month<=12 && year>=1930 && year<=2021){
            isValid=true;
            this.date = date;
        }
        return isValid;
    }
}
