/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John
 */
public class Maze {
    
    private String[] maze;
    
    public Maze()
    {
        maze = new String[16];
        for(int i=0; i<maze.length; i++)
            maze[i] = ".........................................";
        
        for(int i=0; i<50; i++)
        {
            int row = (int)(Math.random()*maze.length);
            int col = (int)(Math.random()*maze[0].length());
            
            maze[row] = maze[row].substring(0,col) + "#" + maze[row].substring(col+1);
        }
    }
    
    public void drawMaze()
    {
        System.out.println("GRID:");
        for(String m : maze ) System.out.println( m );
        System.out.println();
    }
    
   public String[] getMaze()
   {
       return maze;
   }
   
}
