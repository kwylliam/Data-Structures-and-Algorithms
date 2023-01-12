import java.util.*;
public class QueueBox<E> {
    private E[] elements = (E[])( new Object[5] );
    private int front_idx = 0;
    private int rear_idx = 0;
    private int count = 0;

public boolean add(E e) throws NullPointerException{

    	if (e==null){
    		throw new NullPointerException();
    	}
    	else if (count==0){
			elements[0]=e;
			count++;
		}
			
    	else if(count==elements.length){
			resize();
    		elements[rear_idx]=e;
            count++;
            rear_idx=(count-1);
    		return true;
    	}

    	else{
    		elements[rear_idx+1]=e;
    		count++;
    		rear_idx=(count-1);
    		return true;
    	}
    	return true;

    }

    private void resize(){
    	E[] newArr = (E[])(new Object[2*elements.length]);

    		for(int i=0; i<elements.length; i++){
    			newArr[i]=elements[i];
    		}

    	elements=newArr;

    	System.out.println("Array resized to " + elements.length);

    }

    public E remove() throws NoSuchElementException{
        

        if (isEmpty()){
			throw new NoSuchElementException();
			}
		else if(count==1){
			E e=elements[front_idx];
			elements[front_idx]=null;
			count--;
			return e;
			}
		else{
			E e=elements[front_idx];
			for(int i=(front_idx);i<count;i++){
				elements[i]=elements[i+1];
			}
			elements[rear_idx]=null; 
			rear_idx--;
			count--;
			return e;
		}
	}

    public boolean isEmpty(){
    	if (count==0){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    public E element() throws NoSuchElementException{

    	if (isEmpty()){
    		throw new NoSuchElementException();
    	}

    	E e=elements[front_idx];
    	return e;
    }

    public int size(){
    	return count;
    }



}
