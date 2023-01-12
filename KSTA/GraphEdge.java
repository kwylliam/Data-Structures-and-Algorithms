public class GraphEdge<V> implements Comparable<GraphEdge>{

    public V v1;
    public V v2;
    public int e;

    @Override
    public String toString(){
    	String disp=(v1+" to "+v2+" distance = "+e);
    	return disp;
    }

    @Override
    public int compareTo(GraphEdge edge)
    {
        if ( this.e<edge.e ) return -1; // e is less than edge.e
        if ( this.e>edge.e ) return  1; // e is greater than edge.e
        
        return 0; // e is equal to edge.e
    }
}
