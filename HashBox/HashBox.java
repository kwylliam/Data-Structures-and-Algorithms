public class HashBox<K,V> {
    private int hash_table_size = 5;
    private int count = 0;  // The number of VALUES (elements) this hashmap is currently holding.
    LinkedListNode<K,V>[] hash_table = (LinkedListNode<K,V>[])(new LinkedListNode[hash_table_size]);

    public V get(K k){

    	int hash=Math.abs(k.hashCode())%hash_table_size;
    	LinkedListNode<K,V> current=hash_table[hash];
    	while(current!=null){
    		if (compareGeneric(current.key, k)){
    				break;
    			}
    			current=current.next;
    		}
    	if(current==null){
    		return null;
    	}
    	else{
    		return current.v;
    	}
    	}

    public V put(K key, V value){
    	int hash=Math.abs(key.hashCode())%hash_table_size;
    	LinkedListNode<K,V> node= new LinkedListNode<K,V>();
    	node.key=key;
    	node.v=value;
    	if (hash_table[hash]==null){
    		hash_table[hash]=node;
    		count++;
    		return null;
    	}
    	else{
    		if(get(key)==null){
    			node.next=hash_table[hash];
    			hash_table[hash]=node;
    			count++;
    			return null;
    		}
    		else{
    			V val=replaceValue(key, hash, value);
    			return val;
    		}
    	}
    }

    public V remove(K key){
    	int hash=Math.abs(key.hashCode())%hash_table_size;

    	if(get(key)==null){
    		return null;
    	}

    	if (compareGeneric(hash_table[hash].key, key)){
    		V val=hash_table[hash].v;
    		hash_table[hash]=(hash_table[hash].next==null)?null:hash_table[hash].next;
    		count--;
    		return val;
    	}

    	else{
    		LinkedListNode<K,V>current= hash_table[hash];

    		while(current.next!=null){
    			if(compareGeneric(current.next.key, key)) break;
    			current=current.next;
    		}
    		V val=current.next.v;
    		current.next=current.next.next;
    		count--;
    		return val;
    	}
    }

    public int size(){
    	return count;
    }

    public boolean isEmpty(){
    	return(count==0)? true:false;
    }

    private V replaceValue(K key, int index, V value){

    	LinkedListNode<K,V>current= hash_table[index];
    	while (current!=null){
    		if (compareGeneric(current.key, key)){
    			break;
    		}
    		current=current.next;
    	}
    	V val=current.v;
    	current.v=value;
    	return val;
    }

    public void walk(){
    	for(int i=0; i<hash_table_size; i++){
    		System.out.print("#"+i);
    		LinkedListNode<K,V> current =hash_table[i];
    		while( current != null ){
    			System.out.print(" ("+current.key +", " +current.v+")"+"-->");
    			current = current.next;
    		}
    		System.out.println("\n");
    	}
    	
    }

    private static <T> boolean compareGeneric( T first, T second )
    {
        int order = ((Comparable)first).compareTo(second);
        if ( order == 0 ) return true;
        return false;
    }

   
   }