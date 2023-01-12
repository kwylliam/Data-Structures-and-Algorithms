

public class QueueBoxDriver {
	
	public static void main (String[] args) {
		
		QueueBox<Integer> x=new QueueBox<Integer>();
		
		int i=0;
		while(i<60000){
			x.add(i);
			i++;
		}
		i=0;
		
		while(i<50000){
			x.remove();
			i++;
		}
		
		for(i=0; i<10000; i++){
			int j=x.remove();
			System.out.println(j);
		}
		
		
	}
}

