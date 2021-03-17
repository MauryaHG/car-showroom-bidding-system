public class Car {
    public String make;
    public String model;

    public Car(String newMake, String newModel){
        make = newMake;
        model = newModel;
    }
    public String description(){
        return ("Maker: "+ make + " and Model: "+ model);
    }
}
