public class ArrayBox<E>{
    private E[] elements = (E[])(new Object[2]);
    private int end_idx = 0;


    public int size(){

    	return end_idx;
    }

    public boolean isEmpty(){

    	if (end_idx==0){

    		return true;
    	}

    	else
    		return false;
    }

    public boolean add(E e){

    	if(end_idx==elements.length){

    		resize(); //method definded from line 88
    		elements[end_idx]=e;
            end_idx++;
    		return true;
    	}

    	else{
    		elements[end_idx]=e;
    		end_idx++;
    		return true;
    	}

    }

    public E get(int index) throws IndexOutOfBoundsException{

    	if(index<0 || index>=size()){

    		throw new IndexOutOfBoundsException("Index is out of bounds");
    	}

        return elements[index];
    }

    public E set(int index, E element) throws IndexOutOfBoundsException{
    	
    	E e= elements[index];
        elements[index]=element;

    	if (index<0 || index>=size()){

    		throw new IndexOutOfBoundsException("Index is out of bounds");
    	}

        return e;

   
    	}
    	

    public E remove(int index) throws IndexOutOfBoundsException{
        E e=elements[index];
        if (index==(size()-1)){
            elements[index]=null;
            end_idx--;
        }
        else{
            for(int i=(index);i<size();i++)
            {
                elements[i]=elements[i+1];
            }
			
            elements[end_idx]=null; //sets the last value in the Array to null, to avoid a duplicate at the end
			
            end_idx--;

    	if (index<0 || index>=size()){

            throw new IndexOutOfBoundsException("Index is out of bounds");
    	}

	}
	return e;
}

    private void resize(){
    	E[] newArr = (E[])(new Object[2*elements.length]);

    		for(int i=0; i<elements.length; i++){
    			newArr[i]=elements[i];
    		}

    	elements=newArr;

    	System.out.println("ATTN: array capacity has been resized to hold a maximum of " + elements.length);

    }






}
