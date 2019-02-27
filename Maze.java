import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{

  private char[][] maze;
  private boolean animate;

  public Maze(String filename) throws FileNotFoundException{
    animate = false;
    int rows=0;
    int cols=0;
    while (file.hasNextLine()){//run through text file to get dimensions
      rows++;
      String line = file.nextLine();
      for (int i=0;i<line.length();i++){
        cols++;
      }
    }
    maze = new char[rows][cols]; //set dimensions of the maze

    //actually filling out the array with maze info
    File text = new File(filename);
      Scanner file = new Scanner(text);
      int r=0;
      while (file.hasNextLine()){
        String line = file.nextLine();
        for (int i=0;i<line.length();i++){
          characters[r][i]=line.charAt(i);
        }
        r++; //move on to next row
      }
  }

  public static void main(String[] args){
    try{
      Maze maze=new Maze(args[0]);
      System.out.println(maze.toString());
    }catch(FileNotFoundException e){
      System.out.println("File not found :(");
    }
  }
}
