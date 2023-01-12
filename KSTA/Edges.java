import java.util.*;
import java.io.File;
import java.io.IOException;
public class Edges{
	public static void main(String[] args) throws IOException {
		File f=new File("worldcities.csv");
		Scanner sc=new Scanner(f);
		sc.useDelimiter(",|\r");
		ArrayList<GraphEdge<String>> tree= new ArrayList<GraphEdge<String>>();
		

		while(sc.hasNextLine()){
			tree.add(new GraphEdge(sc.next(), sc.next(), sc.nextInt()));
		}
		


	}

	
	

	}
