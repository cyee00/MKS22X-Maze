import java.io.*;
import java.util.*;

public class Maze{

  private char[][] maze;
  private boolean animate;

  public Maze(String filename) throws FileNotFoundException{
    animate = false;
    int rows=0;
    int cols=0;
    File text = new File(filename);
    Scanner file = new Scanner(text);
    while (file.hasNextLine()){//run through text file to get dimensions
      rows++;
      String line = file.nextLine();
      //System.out.println(line);
      for (int i=0;i<line.length();i++){
        cols++;
      }
    }
    maze = new char[rows][cols+1]; //set dimensions of the maze

    //actually filling out the array with maze info
    File text0 = new File(filename);
    Scanner file0 = new Scanner(text0);
    int r=0;
    while (file0.hasNextLine()){
      String line = file0.nextLine();
      for (int i=0;i<line.length();i++){
        //System.out.println(line.charAt(i));
        maze[r][i]=line.charAt(i);
      }
      maze[r][line.length()]='\n';
      r++; //move on to next row
    }
  }

  public String toString(){
    String ans="";
    for (int r=0;r<maze.length;r++){
      for (int c=0;c<maze[r].length;c++){
        ans+=maze[r][c];
        //System.out.println(maze[r][c]);
      }
    }
    return ans;
  }

  public static void main(String[] args){
    try{
      Maze maze=new Maze(args[0]);
      System.out.println(maze.toString());
    }catch(FileNotFoundException e){
      System.out.println("File not found, please enter a valid filename");
    }
  }
}
