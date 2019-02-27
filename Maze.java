import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{

  private char[][] characters;

  public static void main(String[] args){
    File text = new File(args[0]);
    try{
      Scanner file = new Scanner(text);
      int r = 0;
      while (file.hasNextLine()){
        String line = file.nextLine();
        for (int i=0;i<line.length();i++){
          characters[r][i]=line.charAt(i);
        }
        r++; //move on to next row
      }
      System.out.println(characters.toString());
    }catch(FileNotFoundException e){
      System.out.println("File not found :(");
    }
  }
}
