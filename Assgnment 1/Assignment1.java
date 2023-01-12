//William Mwangi
//T00622533
//Assignment 1
import java.util.Scanner;
public class Assignment1{
	public static void main(String[] args) {

	Maze grid = new Maze();

	grid.drawMaze();

	

	//Construct a two-dimensional integer array called sum of size 16x41
	int [][] sum= new int [16][41];	
	
	String[] g = grid.getMaze();
	
	//Populate the sum array
	for(int i=0; i<sum.length; i++){
		for(int j=0; j<sum[i].length;j++){
			int k=0;
			while(k<i){
				sum[i][j]+= hash(g[k], j);
				k++;
				}
			}
		}
		
	
	//Print out the sum array
	for (int i=0; i<sum.length;i++){
		System.out.println();
		for(int j=0; j<sum[i].length; j++){
			System.out.print ((sum[i][j]<10)?sum[i][j] + "  ":sum[i][j]+" " );
			}
		}
	System.out.println("\n");
	
	//Prompt for input
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter coordinates for top left corner eg. a,b");
	String top=sc.nextLine();
	System.out.println("Enter coordinates for bottom left corner");
	String bottom=sc.nextLine();
	
	String [] tl=top.split(",");
	
	String [] br=bottom.split(",");
	int iTop=Integer.parseInt(tl[0]);
	int iBottom=Integer.parseInt(br[0]);
	int jLow=Integer.parseInt(tl[1]);
	int jHi=Integer.parseInt(br[1]);
	
	//display partial grid
	for(int i=iTop; i<=iBottom; i++){
		System.out.println();
		for(int j=jLow; j<=jHi; j++){
			System.out.print(g[i].charAt(j));
		}
	} 	
	
	//Integral imaging calculation Algorithm
	//bottom right- top right- bottom left+top left
	//sum[iBottom][jHi]-sum[iTop][jHi]-sum[iBottom][jLow]+sum[iTop][jLow]
	
	System.out.println();
	System.out.println("Total hashtags in region (using Integral Image technique) is ");
	System.out.print (sum[iBottom][jHi]-sum[iTop][jHi]-sum[iBottom][jLow]+sum[iTop][jLow]);
	
	
	
	
	


	}
	
	//Define a method to count #tags
	
	private static int hash(String s, int end){
		int count=0;
		for(int i=0; i<=end; i++){
			if (s.charAt(i)== '#'){
				count++;
				}
			}
		return count;
		}
}
