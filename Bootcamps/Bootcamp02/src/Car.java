public class Car {
    private String make;
    private String model;

    public Car(String make, String model){
        this.make = make;
        this.model = model;
    }
    public String  getCarDescription(){
        return (this.make + this.model);
    }
}
