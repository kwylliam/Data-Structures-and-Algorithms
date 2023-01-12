import java.util.*;

public class HashBoxDriver {
	
	public static void main (String[] args) {
		HashBox<String,Integer> map=new HashBox<String,Integer>();
		
	while(true){
		
		int i=mainMenu(map);
		Scanner sc=new Scanner(System.in);
		Scanner scan=new Scanner(System.in);
		switch(i){
			
			case 1:{
				System.out.println("Enter the key(String) of the element that you want to put ");
				String k=sc.nextLine();
				System.out.println("Enter the value to be mapped to your key ");
				Integer v=sc.nextInt();
				
				System.out.println("Previous value was "+ map.put(k,v));
				break;
			}
			
			case 2:{
				System.out.println("Enter the key for the element that you want to remove ");
				String k=sc.nextLine();
				System.out.println("You have removed " + map.remove(k));
				break;
			}
			
			case 3:{
				map.walk();
				break;
			}
			
			case 4:{
				System.out.println("Enter the key for the element that you want to retrieve: ");
				String k=sc.nextLine();
				System.out.println("The value matched to "+k+ " is "+ map.get(k));
				break;
			}
			
			case 5:{
				System.exit(0);
				break;
				}
			default:{
				System.out.println("You did not enter a valid option");
			}
		}
	}
		
	}
	
public static int mainMenu(HashBox h){
		Scanner sc=new Scanner(System.in);
		System.out.println("====================");
		System.out.println("Welcome to HashBox");
		System.out.println("====================");
		System.out.println("There are currently "+ h.size()+ " elements in the box ");
		
		System.out.println("Choose...\n1. PUT an element(<String,Integer>) to our box."+
		"\n2. REMOVE an element(<String,Integer>) from our box."+
		"\n3. List the contents of the box \n4.GET an element (<String,Integer>)"+
		"\n5.Exit");
		
		int i=sc.nextInt();
		return i;
	}	
}

