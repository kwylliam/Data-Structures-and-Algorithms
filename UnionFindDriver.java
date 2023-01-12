
import java.util.*;

public class UnionFindDriver {
	
	public static void main (String[] args) {
	
	UnionFind<String> uf= new UnionFind<String>();
	
	while(true){
		int i=mainMenu(uf);
		switch(i){
			case 1:{
				Scanner sc= new Scanner(System.in);
				System.out.println("Enter the string that you want to add");
				String e=sc.nextLine();
				uf.add(e);
				break;
			}
			case 2:{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the index of the first set");
				int s1=sc.nextInt();
				System.out.println("Enter the index of the other set you want to merge.");
				int s2=sc.nextInt();
				uf. union(s1, s2);
				break;
				}
			case 3:{
				Scanner sc=new Scanner(System.in);
				System.out.print("Enter the string you want to search for");
				String e=sc.nextLine();
				Integer ind=uf.find(e);
				System.out.println((ind==null)? e + " was not found": e+" was found in set #"+ind);
				break;
				
				}
			case 4:{
				Scanner sc=new Scanner(System.in);
				System.out.print("Enter the set#");
				int ind=sc.nextInt();
				System.out.println("Set contains: " + uf.get(ind));
				break;
				
				}
			case 5:{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the first string you want to search for");
				String a= sc.nextLine();
				System.out.println("Enter the second string ");
				String b=sc.nextLine();
				System.out.println((uf.find(a, b))?a+ " and "+ b+ " are in the same set": a+" and "+ b + " are not in the same set");
				break;
				}
			case 6:{
				
				uf.display();
				break;
				}
			case 7:{
				System.exit(0);
				}
			default:{
				System.out.println("You have entered an invalid choice");
			}
		}
	}
}
	
	public static int mainMenu(UnionFind h){
		Scanner sc=new Scanner(System.in);
		System.out.println("====================");
		System.out.println("Welcome to UnionFind");
		System.out.println("====================");
		//System.out.println("There are currently "+ h.size()+ " elements in the box ");
		
		System.out.println("Choose...\n1. Add a String element"+
		"\n2. Union (join) two sets"+
		"\n3. FIND the set# for a STRING \n4.GET the SET given the set#"+
		"\n5.TEST(FIND) if STRING s1 and STRING s2 are in the same set"+
		"\n6. Display Union-Find sets"+"\n7. Exit program.");
		
		int i=sc.nextInt();
		return i;
	}	
}

