import java.util.Scanner;
public class App{

  
  public static  class BankAccount{

    String holderName;
    double balance;

    public BankAccount(String holderName,double balance){
      this.holderName = holderName;
      this.balance = balance;

      
    }
    public void ShowDebug(){
      String text = ("Holder name:%s\nCurrent Balance:%f").formatted(holderName,balance);
      System.out.println(text);
    }

  }
  public static class SavingAccount extends BankAccount{
    double interestRate;
    
     public  SavingAccount(String holderName,double balance,double interestRate){
      super(holderName, balance);
      this.interestRate = interestRate;
     }

     @Override 
     public void ShowDebug(){
      super.ShowDebug();
      String text =("Interest Rate:%f").formatted(interestRate);
      System.out.println(text);

     }
    }


    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Enter your name:");
      String userNameInput = scanner.nextLine();
      
      SavingAccount firstCustomer = new App.SavingAccount(userNameInput, 240, 15);
      firstCustomer.ShowDebug();

      scanner.close();

    }

  }

