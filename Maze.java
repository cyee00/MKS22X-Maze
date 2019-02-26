import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{

  private char[] characters;

  public static void main(String[] args){
    File text = new File(args[0]);
    try{
      Scanner file = new Scanner(text);
      while (file.hasNextLine()){
        String line = file.nextLine();
        System.out.println(line);
      }
    }catch(FileNotFoundException e){
      System.out.println("File not found :(");
    }
  }
}
