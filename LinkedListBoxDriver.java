import java.util.*;

public class LinkedListBoxDriver{
	
	public static void main (String[] args) {
		
		LinkedListBox <Integer> l=new LinkedListBox<Integer>();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("How many integers would you like in the list? ");
		int num=sc.nextInt();
		
		for(int i=0; i<num; i++){
			l.add((int)(Math.random()*20)+1);
			}
		System.out.println("Linked list elements");	
		l.walk();
		
		//remove even numbers
		LinkedListNode n =l.head;
		while (n!= null){
			int target=(Integer)n.element;
			if(target%2==0)
			{
			l.remove(target);
			}
			n=n.next;
		}
		
		System.out.println("Evens have been removed");
		l.walk();
	}
}

