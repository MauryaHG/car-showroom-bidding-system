public class Bid {

    private String bidId;
    private Buyer buyer;
    private int bidPrice;
    private String date;

    public Bid(String bidId) {
        this.bidId = bidId;
    }

    public Bid(String bidId, Buyer buyer, int bidPrice, String date) {
        this.bidId = bidId;
        this.buyer = buyer;
        this.bidPrice = bidPrice;
        this.date = date;
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

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
