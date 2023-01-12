import java.util.*;
public class ArrayBoxDriver {
	
	public static void main (String[] args) {
	
	ArrayBox<String> str=new ArrayBox<String>();
	
	while(true){
		int i=mainMenu();
		Scanner sc=new Scanner(System.in);
		Scanner scan=new Scanner(System.in);
		switch(i){
			
			case 1:{
				System.out.println("Type in the element that you want to add ");
				String e=sc.nextLine();
				str.add(e);
				break;
			}
			
			case 2:{
				System.out.print("Enter the index of the element to be removed");
				int j=sc.nextInt();
				str.remove(j);
				break;
			}
			
			case 3:{
				System.out.println("Enter the index of the element to be replaced");
				int j=sc.nextInt();
				System.out.println("What do you want to replace it with?");
				String s=scan.nextLine();
				str.set(j, s);
				break;
			}
			
			case 4:{
				for(int k=0; k<str.size(); k++){
					System.out.print(str.get(k)+", ");
				}
				break;
				}
			case 5:{
				System.exit(0);
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
		System.out.println("Welcome to ArrayBox");
		System.out.println("====================");
		
		System.out.println("Choose...\n1. Add an element(String) to our box.\n2. Remove an element(String) from our box.\n3. Replace(set) an element(String) from our box.\n4. List the contents of the box.\n5. Exit program");
		
		int i=sc.nextInt();
		return i;
		
		
				
			}

}


