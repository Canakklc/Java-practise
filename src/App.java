import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class App{
  
  public static  class Vehicle {
  
    String brand;
    double dailyRate;

    public Vehicle(String brand, double dailyRate){
      this.brand = brand;
      this.dailyRate = dailyRate; 

    }

    public void DisplayInfo(){

      String text=("Car brand:%s\nDaily rate:%f").formatted(brand,dailyRate);
      System.out.println(text);
    }

  }

  public static class Car extends Vehicle{

    int doorCount;

    public Car(String brand, double dailyRate, int doorCount){
      super(brand, dailyRate);
      this.doorCount = doorCount;
    }

    @Override 
    public void DisplayInfo(){
      super.DisplayInfo();
      
      String text =("Door Quantity:%d").formatted(doorCount);
      System.out.println(text);
    }
  }

  public static class Motorcyle extends Vehicle{

    boolean hasHelmet;

    public Motorcyle(String brand, double dailyLimit, boolean hasHelmet){
       super(brand, dailyLimit);
       this.hasHelmet = hasHelmet;
    }

    @Override 
    public void DisplayInfo(){
      String helmetInfo;
      super.DisplayInfo();
      if(hasHelmet == true){
        helmetInfo=("Comes with helmet");
      }else
        {
        helmetInfo =("Does not come with helmet");
      }

      String mainText=(helmetInfo);
      System.out.println(mainText);

    }
  }

  public static void main(String[] args) {
    
    List<Vehicle> vehicleList = new ArrayList<>();
    Map<String,Vehicle> vehicleMap = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    boolean locker =true;
    System.out.println("Welcome\nPress 1 to add car\nPress 2 to add motorcyle\nPress 3 to  view all vehicles\n Press 4 to ShowVehicle info\n Press 5 to quit app");

    while (locker) {
      
      int AnswerInput = scanner.nextInt();
      scanner.nextLine();

      switch (AnswerInput) {
        case 1:
          Car addCar = new App.Car("Aston Martin", 15, 2);
          vehicleList.add(addCar);
          vehicleMap.put(addCar.brand,addCar);
          System.out.println("Car has been added");
          break;
        
          
        case 2:
          Motorcyle addMotor = new App.Motorcyle("Mercedes", 15, false);
          Motorcyle addMotorSec = new App.Motorcyle("Yamada", 12, true);

          Motorcyle[] motors = {addMotor,addMotorSec};
          for (Motorcyle motorsMotorcyle : motors) {
            vehicleList.add(motorsMotorcyle);
            vehicleMap.put(motorsMotorcyle.brand,motorsMotorcyle);
            System.out.println("Motorcyle has been added");  
          }
          break;
         case 3:
            if (vehicleList.isEmpty()) {
                System.out.println("List is empty");
            } else {
                for (int i = 0; i < vehicleList.size(); i++) {
                    vehicleList.get(i).DisplayInfo();
                }
            }

            break;  
          case 4:
            System.out.println("Enter the brand name");
            String brandNameInput =scanner.nextLine();

            if(vehicleMap.containsKey(brandNameInput)){
              System.out.println("Car has been found");
              Vehicle foundVehicle = vehicleMap.get(brandNameInput);

              foundVehicle.DisplayInfo();
            }else
            {
              System.out.println("Car could not have been found");
            } break;
          case 5:
            System.out.println("Quiting");
            locker = false;
            break;
      }
    }

  }
}