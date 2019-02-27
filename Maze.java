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

  private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
            //find the location of the S.

            //erase the S

            //and start solving at the location of the s.
            //return solve(???,???);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
        return -1; //so it compiles
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
