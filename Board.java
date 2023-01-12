import java.util.*;
public class Board<T>
{
public Stack<T>[] points = (Stack<T>[])(new Stack[26]);

//Implement a counting array to keep track of the number of elements in every stack for display purposes 
public Integer[] counter=new Integer[26];

public int humanBarCounter, computerBarCounter;

public Dice dice1=new Dice(); 
public Dice dice2=new Dice();

private Character player='W';
private Character comp='B';

// Constructor that intitializes all the stacks in points to avoid null pointer excetions
public Board(){
	
	for(int i=0; i<26; i++){
		points[i]= new <T> Stack();
		counter[i]=0;
		}
	computerBarCounter=0;
	humanBarCounter=0;
}


//add method to push characters onto the stacks
public void add(int ind,T x){
	points[ind].push(x);
	counter[ind]++;
}

//remove method
public T remove(int ind){
	T piece=points[ind].pop();
	counter[ind]--;
	return piece;
	
}

//bump method
private void bump(int ind){

	T piece=remove(ind);

	if (piece==player){

		humanBarCounter++;
	}

	else{
		computerBarCounter++;
	}

}

//move method

private int[] move(Character t){
	if(t==comp){
		int r1=(dice1.roll());
		int r2=(dice2.roll());
		System.out.println("The Computer has rolled "+ r1 + " on dice1 and "+ r2 +" on dice2");
		int[] rolls={r1, r2};
		return rolls;
	}

	else{
		int r1=dice1.roll();
		int r2=dice2.roll();
		System.out.println("You have rolled "+ r1 + " on dice1 and "+ r2 +" on dice2");
		int[] rolls={r1, r2};
		return rolls;
	}
}

//checkvalidity method
private boolean check(int p, int roll, Character t){
	if(p<=0){
		return false;
	}
	if(p+roll>25){
		System.out.println("Illegal move");
		return false;
	}
	if (points[p].isEmpty()){

		System.out.println("Illgal move, you have lost a turn");
		return false;
	}
	T start=points[p].peek();

	if (start!=t){

		System.out.println("illegal move, you have lost a turn.");
		return false;
	}
	if (points[p+roll].isEmpty()){
		return true;
	}
	else{
		T destination=points[p+roll].peek();
		if(destination!=t && counter[p+roll]==1)
		{
			bump(p+roll);
			return true;
		}

		else if(counter[p+roll]>1 && destination!=t)
		{
			System.out.println("Illegal move, Turn lost");
			return false;
		}

	}
		
	return true;
	
}

//humanPlayerMove method
public void humanPlay(){
	if (humanBarCounter==0){
		int[] rolls=move(player);
		Scanner sc=new Scanner(System.in);
		System.out.println("Which point would you like to move from for dice 1");
		int p=sc.nextInt();
		boolean validity=check(p, rolls[0], player);
		if (validity){
			try{
				add((p+rolls[0]), remove(p));
			}
			catch(ArrayIndexOutOfBoundsException ex){
				System.out.println("Illegal move. Lost turn");
			}
			
		}
		display();
		System.out.println("Which point would you like to move from for dice 2");
		p=sc.nextInt();
		validity=check(p, rolls[1], player);
		if (validity){
			try{
				add((p+rolls[1]), remove(p));
			}
			catch(ArrayIndexOutOfBoundsException ex){
				System.out.println("Illegal move. Lost turn");
			}
			
		}
		display();
	}
	else{
		int[] rolls = move(player);
		if (rolls[0]==rolls[1]){
			humanBarCounter--;
		}
		display();
	}
	}


public boolean computerPlay(){

	if (computerBarCounter==0){
		int[] rolls=move(comp);
		int p=pick(rolls[0]);

		if (p==0){
			System.out.println("no valid moves");
			return true;
		}
		else{
			add(p-rolls[0], remove(p));
			display();
		}

		p=pick(rolls[1]);
		if (p==0){
			System.out.println("no valid moves");
			return true;
		}
		else{
			add(p-rolls[1], remove(p));
			display();
		}
	}

	else{
		int[] rolls = move(comp);
		if (rolls[0]==rolls[1]){
			computerBarCounter--;
		}
		display();
	}
	return true;
}

public int pick(int r){
	int i=25;
	while(i>0){
		try{
			T x=points[i].peek();
			if(x==player){
				i--;
			}
			else if (x==comp){
				try{
					T t=points[i-r].peek();
					if (t==comp){
						return i;
					}
					else{
						i--;
					}
				}
				catch(EmptyStackException ex){
					return i;
				}
				catch(ArrayIndexOutOfBoundsException ex){
					return 0;
				} 
			}
		}
		catch(EmptyStackException ex){
			i--;
		}
		
	}
	return 0;
	}


public void display(){

	for (int i=0; i<26; i++){

		if (points[i].isEmpty()){
			System.out.println(i+":");
			}
		else{
			System.out.print(i+":");
			T color=points[i].peek();
			for(int j=0;  j< counter[i]; j++){
				if (color==player){
					System.out.print("\u001B[30m"+"\u001B[44m"+color+"\u001B[0m");
				}
				else if(color==comp){
					System.out.print("\u001B[30m"+"\u001B[41m"+color+"\u001B[0m");
				}
		}
	System.out.println();
	}
		}
	
	System.out.println("*****[ THE STATS ]***** \nHuman player has "+ humanBarCounter+" stones in bar \nComputer player has "+ computerBarCounter+" stones in bar\nHuman player has "+ counter[25]+" stones at home point 25\nComputer player has "+ counter[0]+" stones at home point 0");
	}
}





