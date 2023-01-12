public class LinkedListBox<E>
{
    public LinkedListNode<E> head;
    public int count = 0;

    //Methods
    public boolean isEmpty(){
    	if (head==null){
    		return true;
    	}
    	else{
    		return false;
    	}

    }

    public boolean add(E e){
    	if (isEmpty()){
    		LinkedListNode<E> node= new LinkedListNode<E>();
    		node.element = e;
    		head=node;
    		count++;
    		return true;
    	}
    	else{
    		LinkedListNode<E> node= new LinkedListNode<E>();
    		node.element = e;
    		node.next=head;
    		head = node;
    		count++;
    		return true;
    	}
    }

    public void walk(){
    	LinkedListNode<E> current = head;
    	while( current != null ){
    		System.out.print( "-->" + current.element);
    		current = current.next;
    	}
    	System.out.println("\n");
    }

    public E remove(E e){
    	if (head.element==e){
    		E prev = head.element;
    		head = head.next;
    		count --;
    		return prev;
    	}
    	else{
    		LinkedListNode<E> current = head;
    		while(current.next.element!=e){
    			current=current.next;
    		}
    		E prev = current.next.element;
    		current.next = current.next.next;
    		count--;
    		return prev;
    	}

    }


}
