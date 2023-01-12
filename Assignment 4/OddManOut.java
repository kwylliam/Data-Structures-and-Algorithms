import java.util.*;
public class OddManOut {
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many random Integers to produce?");
        int num = sc.nextInt();
        
        ArrayList<Integer> randomInts = createRandomList(num);
        System.out.println("The random list is: ");
        System.out.println(randomInts);
        
        removeOdds( randomInts );
        System.out.println("The random list with only even numbers: ");
        System.out.println(randomInts);
        
    }
    
    public static ArrayList<Integer> createRandomList(int num)
    {
        ArrayList<Integer> arr= new ArrayList<Integer>();
        for(int i=0; i<num; i++){

            arr.add((int)(Math.random()*20)+1);
        }

        return arr;
    }
    
    public static void removeOdds(ArrayList<Integer> list)
    {
        for(int i=0; i<list.size(); i++){

            if(list.get(i)%2!=0){

                list.remove(i);
                i--;
            }
        }
    }
}