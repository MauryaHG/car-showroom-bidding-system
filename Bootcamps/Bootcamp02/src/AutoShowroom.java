import java.util.ArrayList;

public class AutoShowroom {

    ArrayList<Car> carArray = new ArrayList();
    public void printStatus() {
        System.out.println("Welcome to FIT2099 Showroom");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");
    }

    public void createCars() {
        carArray.add(new Car("BMW", "X7"));
        carArray.add(new Car("Audi", "A8"));
        carArray.add(new Car("Mercedes", "GLS"));
    }

    public void displayCars(){
        for (int i =0; i < carArray.size(); i++) {
            System.out.println("Car (" +(i+1)+ ") " +carArray.get(i).description());
        }
    }
}