import java.util.*;
public class StackGammon
{
	public static void main(String[] args) {

	Board<Character> gameboard = new Board<Character>();
	reset(gameboard);
	System.out.println("***** [ THE BOARD ] *****");
	gameboard.display();
	
	
	menu(gameboard);	
	

	}
  
//reset method sets the board to its intital state
public static void reset(Board a){

	for(int i=0; i<2; i++){
		a.add(1, 'W');
		a.add(24, 'B');
	}

	for(int i=0; i<5; i++){



		a.add(6, 'B');
		a.add(19, 'W');
		a.add(13, 'B');
		a.add(12, 'W');
	}

	for(int i=0; i<3; i++){
		a.add(17, 'W');
		a.add(8, 'B');
	}
}

//menu method
public static void menu(Board a){

	Scanner sc=new Scanner(System.in);

	System.out.println(" It's your turn choose an option: \n1. play \n2.reset the game \n3. exit the game");

	int s=sc.nextInt();

	switch(s){

		case 1:{

			a.humanPlay();
			a.computerPlay();
			menu(a);
		}

		case 2:{

			reset(a);
		}

		case 3:{

			System.exit(0);
		}

		default:{
			System.out.println("Invalid choice");
			menu(a);
		}

	}


}
}
