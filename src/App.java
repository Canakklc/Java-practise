import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class App{

  public static class StudentDatas{

  private String studentNumber;
  private String nameSurname;
  private String className;
  private double midtermNote;
  private double finalNote; 
  
  public StudentDatas(String studentNumber, String nameSurname, String className, double midtermNote,double finalNote ){
    this.studentNumber = studentNumber;
    this.nameSurname = nameSurname;
    this.className = className;
    this.midtermNote = midtermNote;
    this.finalNote = finalNote;
  }

  public String getStudentNumber(){
    return this.studentNumber;
  }

  public String getNameSurname(){
    return this.nameSurname;
  }

  public String getClassName(){
    return this.className;
  }

  public double GetMidterm(){
    return this.midtermNote;
  }
  public double GetfinalNote(){
    return this.finalNote;
  }
  public void SetMidfinal(double midtermNote, double finalNote){
    this.midtermNote =midtermNote;
    this.finalNote = finalNote;
  }

  public void ShowInfo(){
    String text = ("Student Number:%s\nName and Surname:%s\nClass:%s\nMidterm:%f\nFinal:%s").formatted(studentNumber,nameSurname,className,midtermNote,finalNote);
    System.out.println(text);
  }
  public class Calculation{

    public double CalculateAverage(double midtermNote, double finalNote){
      
      double average =(StudentDatas.this.midtermNote * 0.40) + (StudentDatas.this.finalNote * 0.60);
      return average;
    }

    public String AABB(){
      double result = CalculateAverage(midtermNote, finalNote);
      if(result >= 85){
        return "AA";
      }
      else if(result >= 75){
        return "BA";
      }
      else if(result >= 65 ){
        return "BB";
      }
      else if(result >= 60){
        return "CB";
      }
      else if(result >=50){
        return "CC";
      }else{
        return "FF Failed";
      }
    }

    public void AdjustShowInfo(){
      
      StudentDatas.this.ShowInfo();
      System.out.println(Calculation.this.AABB());
    }
  }

  public static void main(String[] args) {
    
    try {
      Scanner scanner = new Scanner(new File("data.txt"));
      while(scanner.hasNextLine()){
        String line = scanner.nextLine();
        String Lines[] = line.split(";");
        double midtermDouble = Double.parseDouble(Lines[3]);
        double finalDouble = Double.parseDouble(Lines[4]);

        StudentDatas studentDatas = new StudentDatas(Lines[0], Lines[1], Lines[2],midtermDouble, finalDouble);
        //studentDatas.ShowInfo();
        
        StudentDatas.Calculation cal = studentDatas.new Calculation();
        cal.CalculateAverage(midtermDouble, finalDouble);
        cal.AdjustShowInfo();
      }
      
    } catch (Exception e) {
      System.out.println("File could not found");
    }
  }



}
}
