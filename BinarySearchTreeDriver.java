import java.util.*;
public class BinarySearchTreeDriver {
	
	public static void main (String[] args) {

		BinarySearchTree<Integer> bst=new BinarySearchTree<Integer>();

		while (true){
			int i=mainMenu();
			switch (i){
			case 1: {
				while(true){
					Scanner sc= new Scanner(System.in);
					try{
						System.out.println("Enter the integer to add to tree (type stop to exit)");
						Integer j=sc.nextInt();
						bst.add(j);
					}
					catch(InputMismatchException ex){
						if(sc.nextLine().trim().equals("stop")) break;
					} 
				}
				break;
			}

			case 2:{
				System.out.println("PARENT\t NODE.E\t NODE.LEFT\t NODE.RIGHT");
				bst.display(bst.root);
				break;
			}
			
			case 3:{
				Scanner sc=new Scanner(System.in);
				System.out.println("What integer are you looking for? ");
				Integer j=sc.nextInt();
				System.out.println ("Is "+ j + " in the tree? " + ((bst.find(j))?" true":" false"));
				break;
			}
			case 4:{
				ArrayList<Integer> a=bst.sort();
				for(Integer j: a){
					System.out.print(j+", ");
				}
				System.out.println();
				break;
			}
			case 5:{
				Scanner sc=new Scanner(System.in);
				System.out.println("What INTEGER are you looking to delete? ");
				Integer j=sc.nextInt();
				bst.remove(j);
				break;
			}
			case 6:{
				System.exit(0);
			}
			default:{
				break;
			}
		}
	}
	}

	public static int mainMenu(){

		Scanner sc=new Scanner(System.in);
		System.out.println("====================");
		System.out.println("Welcome to BST");
		System.out.println("====================");
		
		System.out.println("Choose...\n1. Add Integer(s) to the tree"+
		"\n2. Display Tree"+
		"\n3. Find an element \n4.Perform a tree sort on the elements"+
		"\n5. Remove an Integer (element) from the tree\n6.Exit the program.");
		
		int i=sc.nextInt();
		return i;
	}	
}


