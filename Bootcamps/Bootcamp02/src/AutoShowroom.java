public class AutoShowroom {

    public static Car[] carArray = new Car[3];
    public void printStatus() {
        System.out.println("Welcome to FIT2099 Showroom");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");
    }

    public void createCars() {
        carArray[0] = new Car("BMW", "X7");
        carArray[1] = new Car("Audi", "A8");
        carArray[2] = new Car("Mercedes", "GLS");
    }

    public void displayCars(){
        for (int i =0; i < carArray.length; i++) {
            System.out.println("Car (" +(i+1)+ ") " +carArray[i].getCarDescription());
        }
    }
}