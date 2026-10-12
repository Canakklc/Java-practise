
import java.util.Scanner;

public class App {

   String charName;
   int health;

   public App(String charName, int health){
    this.charName = charName;
    this.health = health;
   }
   public void ShowDebug(){
     
   String text =("%s is making an attack. %s's health:%d").formatted(charName,charName,health);
   System.out.println(text);
   }

    public static  class Mage extends App {
    int  mana;

    public Mage(String charName,int health, int mana){
        super(charName, health);
        this.mana = mana;
    }

     @Override
    public void ShowDebug(){
          super.ShowDebug();
        
          String text =("mana used:%d").formatted(mana);
          System.err.println(text);
        }
   } 


  
   public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the name of the char");
    String charName =scanner.nextLine();

    System.out.println("Enter the health amount");
    int health =scanner.nextInt();

    System.out.println("Enter your mana");
    int manaVal=scanner.nextInt();

     Mage myMage = new Mage(charName, health, manaVal);
     myMage.ShowDebug();
     
     scanner.close();

     
   }
}