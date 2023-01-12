import java.util.*;
public class Walk{
public static void main(String[] args) {

//Part1 (non recursive)
//---------------------

Scanner sc=new Scanner(System.in);
System.out.println("Enter the distance from the door");
double distance=sc.nextDouble();
System.out.println("Enter the number of steps taken");
int steps=sc.nextInt();

System.out.println("Distance walked using iteration = " + distWalked(distance, steps));

System.out.println("Distance walked using recursion= " + distWalked2(distance, steps));

//Part 2 (recursive)


}

private static double distWalked(double distance, int steps){

	int i=1;
	double walkedDistance=0;

	while(i<=steps){
		walkedDistance+=distance/2;
		distance-=distance/2;
		i++;
	}

	return walkedDistance;
}

private static double distWalked2(double distance, int steps){


	if (steps>0){
		return (distance/2)+distWalked2(distance/2, steps-1); 
	}

	else{
		return 0;
	}

}



}






