import java.util.*;

public class StackBox<E>
{
  ArrayList<E> stack = new ArrayList<E>();
  private int count;

 

  public boolean empty(){
  	if (stack.isEmpty()==true){
  		return true;
  	}
  	else{
  		return false;
  	}
  }

  public E push(E item){

  	stack.add(item);

  	return item;
  }

  public E pop() throws EmptyStackException{

  	if (stack.isEmpty()){
  		throw new EmptyStackException();
  	}
  	
  	else{
		int k=stack.size();
		E e=stack.remove(k-1);
		return e;
	}

  	

  }

  public E peek() throws EmptyStackException{
  	
  	if (stack.isEmpty()){
  		throw new EmptyStackException();
  	}
  	
  	else{
		int k=stack.size();
		E e=stack.get(k-1);
		return(e);
		}

}









}
