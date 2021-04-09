package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;

import java.util.StringTokenizer;

public class Bid {

    private String bidId;
    private Buyer buyer;
    private int bidPrice;
    private String date;


    public Bid(String bidId, Buyer buyer, int bidPrice, String date) {
        this.bidId = bidId;
        this.buyer = buyer;
        setBidPrice(bidPrice);
        setDate(date);
    }

    public String getBidId() {

        return bidId;
    }

    public void setBidId(String bidId) {

        this.bidId = bidId;
    }

    public Buyer getBuyer() {

        return buyer;
    }

    public void setBuyer(Buyer buyer) {

    this.buyer = buyer;
    }

    public int getBidPrice() {

        return bidPrice;
    }

    public boolean setBidPrice(int bidPrice) {
        boolean isValid=false;
        if(bidPrice>=0){
            isValid=true;
            this.bidPrice = bidPrice;
        }
        return isValid;

    }

    public String getDate() {

        return date;
    }

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
