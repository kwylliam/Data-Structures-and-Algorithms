import java.util.*;
public class UnionFind<E> {
    public ArrayList<HashSet<E>> sets = new ArrayList<HashSet<E>>(); 

    public Set get(int set){

    	Set<E> s=sets.get(set);

    	return s;
    }

    public int add(E e){

    	HashSet<E>h =new HashSet<E>();

    	h.add(e);

    	sets.add(h);

    	return(sets.indexOf(h));
    }

    public void display(){
    	for(int i=0; i< sets.size(); i++){
    		System.out.print("Set #"+i+": ");
    		System.out.println(get(i));
    	}
    }

    public int union(int set1, int set2){

    	HashSet<E> s1=sets.get(set1);

    	HashSet<E> s2 =sets.get(set2);

    	if (s1.size()>s2.size()){
    		s1.addAll(s2);
    		s2.clear();
    		return set1;
    	}
    	else{
    		s2.addAll(s1);
    		s1.clear();
    		return(set2);
    	}

    }

    public boolean find(E e1, E e2){
    	for(int i=0; i<sets.size(); i++){
    		HashSet<E> h=sets.get(i);
    		if(h.contains(e1)){
    			if(h.contains(e2)) return true;
    		}
    	}
    	return false;
    }

    public Integer find(E e1){
    	for(int i=0; i<sets.size(); i++){
    		HashSet<E> h= sets.get(i);
    		if(h.contains(e1)){
    			return i;
    		}
    	}
    	return null;
    }


}