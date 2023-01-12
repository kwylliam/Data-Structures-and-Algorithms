import java.util.*;
import java.io.FileReader;
import java.io.IOException;
public class KruscalsMSTA {
    public static void main (String[] args)throws IOException {
		
	ArrayList<GraphEdge<String>> tree= new ArrayList<GraphEdge<String>>();
	PriorityQueue<GraphEdge<String>> edges=new PriorityQueue<GraphEdge<String>>();
	UnionFind<String> uf= new UnionFind<String>();
	FileReader f=new FileReader("worldcities.csv");
	Scanner sc=new Scanner(f);
	sc.useDelimiter(",|\\r"); 
	
	while(sc.hasNextLine()){
		GraphEdge<String>g=new GraphEdge<String>();
		g.v1=sc.next().trim();
		g.v2=sc.next().trim();
		g.e=sc.nextInt();
		edges.add(g);
		}
	while(edges.size()!=0){
		GraphEdge<String>g=edges.poll();

		int a =check(g, uf, tree);
		//System.out.println(" Now checking "+ g + "\nChecks as case: "+ a);
		

		switch(a){
			case 1:{
				uf.union(uf.add(g.v1), uf.add(g.v2));
				tree.add(g);
				break;
			}
			case 2:{
				uf.union(uf.add(g.v1),uf.find(g.v2));
				tree.add(g);
				break;
			}
			case 3:{
				uf.union(uf.find(g.v1), (Integer)uf.add(g.v2));
				tree.add(g);
				break;
			}

			case 4: {
				uf.union(uf.find(g.v1), uf.find(g.v2));
				tree.add(g);
				break;
			}

			default:{
				break;
			}

		}
		//uf.display();
		//System.out.println("===================================\n");
	}

	//uf.display();

	int weight=0;

	System.out.println("Minimum Spanning Tree\n");
	for(GraphEdge i: tree){
		weight+=i.e;
		System.out.println(i);
		System.out.println();
	}

	System.out.println("Weight of tree= " + weight);


	}
	public static int check(GraphEdge<String> g, UnionFind u, ArrayList<GraphEdge<String>> a){
		Integer set1=u.find(g.v1);
		Integer set2=u.find(g.v2);
		
		

		//System.out.println(g.v2);
		
		//System.out.println("set1= "+ set1);
		//System.out.println("set2= " + set2);

		if(set1==null && set2== null) return 1;

		if(set1==null && set2!=null) return 2;

		if(set1!=null && set2==null) return 3;
			

		if(set1!=null && set2!= null && !set1.equals(set2)) return 4;

		return 0;
	}
}

