import java.util.*;
public class StackBoxDriver {
	
	public static void main (String[] args) {
	
	StackBox<Integer> stk=new StackBox<Integer>();
	
	while(true){
		 i=mainMenu();
		Scanner sc=new Scanner(System.in);
		Scanner scan=new Scanner(System.in);
		switch(i){
			
			case 1:{
				System.out.println("Enter the integer that you want to push ");
				Integer e=sc.nextInt();
				stk.push(e);
				break;
			}
			
			case 2:{
				try{
					int j=stk.pop();
					System.out.println("You have popped "+ j);
					break;
				}
				catch(EmptyStackException ex){
					System.out.println("Stack is empty. Caught EmptyStackException");
					break;
				}
			}
			
			case 3:{
				try{
					int j=stk.peek();
					System.out.println(j+" Is at the top of the Stack");
					break;
				}
				catch(EmptyStackException ex){
					System.out.println("Stack is empty. Caught EmptyStackException");
					break;
				}
			}
			
			case 4:{
				System.exit(0);
				break;
			}
			default:{
				System.out.println("You did not enter a valid option");
			}
		}
	}
		
		
		
	}
	
	public static int mainMenu(){
		Scanner sc=new Scanner(System.in);
		System.out.println("====================");
		System.out.println("Welcome to StackBox");
		System.out.println("====================");
		
		System.out.println("Choose...\n1. Push a (Integer) to our stack box.\n2. Pop a (Integer) off our stack box.\n3. Peek at top of the stack.\n4. Exit");
		
		int i=sc.nextInt();
		return i;
		
		
				
			}

}
