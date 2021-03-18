import java.util.ArrayList;

public class AutoShowroom {

    ArrayList<Car> carArray = new ArrayList();
    ArrayList<Buyer> buyerArray = new ArrayList<>();
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

        buyerArray.add(new Buyer("AAAAA", "Issac", "Newton"));
        buyerArray.add(new Buyer("AAAAB", "Keanu", "Revees"));
        buyerArray.add(new Buyer("AAAAC", "Jhon", "Cena"));

    }

    public void displayCars(){
        for (int i =0; i < carArray.size(); i++) {
            System.out.println("Car (" +(i+1)+ ") " +carArray.get(i).description());
            System.out.println("Car (" +(i+1)+ ") " +buyerArray.get(i).description());
        }
    }
}