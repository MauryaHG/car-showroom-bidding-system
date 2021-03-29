public class Sedan extends Vehicle {
    private int seats;

    public Sedan(String newMaker, String newModel, int seats) {
        super(newMaker, newModel);
        this.seats = seats;
    }

    public Sedan(String maker, String model, int vId, int seats) {
        super(maker, model, vId);
        this.seats = seats;
    }
}
