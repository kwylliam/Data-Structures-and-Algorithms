import java.util.*;
public class BinarySearchTree<E>{
	public BinarySearchTreeVertex<E> root = null;
	public boolean add(E e){
		if (root==null){
			root = new BinarySearchTreeVertex<E>();
			root.e = e;
			return true;
		}
		else{
			BinarySearchTreeVertex<E> current= root;
			while (current!= null){
				if (compareGeneric(e,current.e)>0){
					if (current.right_child==null){
						current.right_child=new BinarySearchTreeVertex<E>();
						current.right_child.e=e;
						current.right_child.parent=current;
						return true;
					}
					else current=current.right_child;
				}
				else if(compareGeneric(e,current.e)<0){
					if (current.left_child==null){
						current.left_child=new BinarySearchTreeVertex<E>();
						current.left_child.e=e;
						current.left_child.parent=current;
						return true;
					}
					else current=current.left_child;
				}
				else if(compareGeneric(e, current.e)==0){
					int i=(int)(Math.random()*2);
					if (i==1){
						if (current.right_child==null){
							current.right_child=new BinarySearchTreeVertex<E>();
							current.right_child.e=e;
							current.right_child.parent=current;
							return true;
						}
						else current=current.right_child;
					}
					else{
						if (current.left_child==null){
							current.left_child=new BinarySearchTreeVertex<E>();
							current.left_child.e=e;
							current.left_child.parent=current;
							return true;
						}
						else current=current.left_child;
					}
				}
			}
		}
		return true;
	}
	private static <E> int compareGeneric( E first, E second ){
		int order = ((Comparable)first).compareTo(second);
		return order;
	}
	public boolean find(E e) {
		BinarySearchTreeVertex<E> current=root;
		while (current!= null){
			if (compareGeneric(e, current.e)==0) return true;
			if (compareGeneric(e, current.e)>0) current=current.right_child;
			else if(compareGeneric(e, current.e)<0)current=current.left_child;
		}

		return false;
	}
	public ArrayList<E> sort() {
		ArrayList<E> l=new ArrayList<E>();
		listAdd(root, l);
		return l;
		}

	public void display(BinarySearchTreeVertex<E> n){
		if (n==null) return;
		System.out.println(((n.parent==null)?"null":n.parent.e)+"\t "+ n.e+"\t "+((n.left_child==null)?"null":n.left_child.e)+"\t\t"+((n.right_child==null)?"null":n.right_child.e));

		if(n.left_child != null){
			display(n.left_child);
		}

		if(n.right_child != null){
			display(n.right_child);
		}
	}



	private void listAdd(BinarySearchTreeVertex<E> v, ArrayList<E> l){
		if (v!=null){
			listAdd(v.left_child,l);
			l.add(v.e);
			listAdd(v.right_child, l);
		}

	}

	private int check(BinarySearchTreeVertex<E> n) {
		//case one: leaf
		if(n.left_child==null && n.right_child==null){
			if (n.parent.left_child.equals(n)) return 0;
			if (n.parent.right_child.equals(n)) return 1;
		}

		//case 2 one child:
		else if(n.left_child==null && n.right_child != null) return 2;

		else if(n.left_child != null && n.right_child ==null) return 3;

		//case 4 two children

		if (n.left_child!=null && n.right_child!=null) return 4;
		else return -1;
	}


	private BinarySearchTreeVertex<E> get(E e) {
		BinarySearchTreeVertex<E> current=root;
		while (current!= null){
			if (compareGeneric(e, current.e)==0) return current;
			if (compareGeneric(e, current.e)>0) current=current.right_child;
			else if(compareGeneric(e, current.e)<0)current=current.left_child;
		}

		return null;
	}

	public boolean remove(E e){
		BinarySearchTreeVertex<E> n= get(e);

		if (n==null) return false;

		int i=check(n);

		switch (i){
			case 0:{
				n.parent.left_child=null;
				return true;
			}
			case 1:{
				n=n.parent.right_child=null;
				return true;

			}
			case 2:{
				if(n.parent.left_child==n){
					n.parent.left_child=n.right_child;
				}
				else if(n.parent.right_child==n){
					n.parent.right_child=n.right_child;
				}
				n.right_child.parent=n.parent;
				return true;
			}
			case 3:{
				if(n.parent.left_child==n){
					n.parent.left_child=n.left_child;
				}
				else if(n.parent.right_child==n){
					n.parent.right_child=n.left_child;
				}
				n.left_child.parent=n.parent;
				return true;
			}
			case 4:
			ArrayList<E> l=sort();
			int j=(l.indexOf(n.e));
			E pred=l.get(j-1);
			remove(pred);
			n.e=pred;
			break;
		}
		return false;
	}





	

}
