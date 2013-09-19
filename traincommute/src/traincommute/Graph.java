package traincommute;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Graph {
	private class Vertex{
		private String label;
		private ArrayList<Edge> edges;
		private boolean visited;
		private int cost;
		public Vertex(String name){
			label = name;
			edges = new ArrayList<Edge>();
			visited = false;
		}
		public boolean add(Edge e)
		{
			boolean found = false;
			for(int i = 0; i < edges.size(); i++){
				if(edges.get(i).target().str().equals(e.target().str()))
					found = true;
			}
			if(!found){
				edges.add(e);
				return !found;
			}
			return !found;
		}
		public String str(){
			if(label != null)
				return label;
			else
				return "";
		}
		public Edge findEdge(String target){
			for(int i =0; i < edges.size(); i++){
				if(edges.get(i).target().str().equals(target)){
					return edges.get(i);
				}
			}
			return null;
		}
		public void print(){
			for(int i = 0; i < edges.size(); i++)
				edges.get(i).print();
		}
	}
	private class Edge{
		private int cost;
		private Vertex target;
		public Edge(Vertex v, int c){
			target = v;
			cost = c;
		}
		public int cost(){
			return cost;
		}
		public Vertex target(){
			return target;
		}
		public void print() {
	        System.out.print("(" + target.str() + ", " + cost + ") "); }
	}
	
	private TreeMap<String, Vertex> vertices;
	private boolean debug = false;
	public Graph(){
		vertices = new TreeMap<String, Vertex>();
	}
	public Graph(boolean debug){
		this.debug = debug;
	}
	public int findDistance(String s){
		if(s == null)
			return 0;
		if(s.length() == 1)
			return 0;
		int distance = 0;
		for(int i = 0; i < s.length(); i++){
			Vertex v = vertices.get("" +s.charAt(i));
			if(v != null){
				if((i+1) < s.length()){
					Edge e = v.findEdge("" + s.charAt(i+1));
					if(e != null)
						distance += e.cost();
					else{
						return 0;
					}
				}
				else
					return distance;
			}
			else
				return 0;
		}
		return distance;	
	}
	public void add(String s){
		if(s.length() != 3){
			if(debug)
				System.out.println("Cannot add Vertex/Edge. " + s + "is not in the expected form \"[A-Za-z][A-Za-z][0-9]\"");
		}
		else
		{
			if(debug)
				System.out.println("Start add process " + s);
			Vertex start = vertices.get("" + s.charAt(0));
			if(start == null){
				start = new Vertex("" + s.charAt(0));
				vertices.put("" + s.charAt(0), start);
			}
			Vertex destination = vertices.get("" + s.charAt(1));
			if(destination == null){
				destination = new Vertex("" + s.charAt(1));
				vertices.put("" + s.charAt(1), destination);
			}
			Edge connection = new Edge(destination, Character.getNumericValue(s.charAt(2)));
			if(debug)
				System.out.println("debug: edge target " + destination.str() + " numeric: " + Character.getNumericValue(s.charAt(2)));
			if(!start.add(connection))
				if(debug)
					System.out.println("Edge " + s + " could not be added. Edge exists already");
		}
	}
	
	public int tripsWithStops(String start, String end, int stops, boolean exact){
		Vertex begin = vertices.get(start);
		if(begin == null)
			return 0;
		int count = 0;
		stops--;
		if(stops >= 0){
			for(Edge e: begin.edges){
				count += tripsToTarget(e.target, end, stops, exact);
			}
		}
		return count;
	}
	private int tripsToTarget(Vertex start, String end, int stops, boolean exact){
		if(stops != 0 && !exact && start.str().equals(end)){
			return 1;
		}
		else if(stops == 0){
			if(start.str().equals(end))
				return 1;
			else
				return 0;
		}
		else{
			int count = 0;
			stops--;
			for(Edge e : start.edges){
				count += tripsToTarget(e.target, end, stops, exact);
			}
			return count;
		}
	}
	public int shortestRoute(String start, String end){
		Vertex v = vertices.get(start);
		if(v == null)
			return 0;
		Collection<Vertex> c = vertices.values();
		Iterator<Vertex> it = c.iterator();
		while(it.hasNext()){
			Vertex vert = it.next();
			vert.visited = false;
			vert.cost = Integer.MAX_VALUE;
		}
		v.cost = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(20,new Comparator<Vertex>() {
			public int compare(Vertex i, Vertex j) {
				return (i.cost - j.cost); 
			}
		});
		if(start.equals(end)){
			for ( Edge e : v.edges ){
	        	int newcost = v.cost + e.cost;
	            if ( newcost < e.target.cost ){ 
	            	e.target.cost = newcost;
	            	pq.add(e.target);  
	            }
	        }
			v.cost = Integer.MAX_VALUE;
		}
		else
			pq.add(v);
		while ( ! pq.isEmpty() )
		{
		    Vertex vertex = pq.remove();
		    if ( ! vertex.visited ){ 
		    	vertex.visited = true;
		        for ( Edge e : vertex.edges ){
		        	int newcost = vertex.cost + e.cost;
		            if ( newcost < e.target.cost ){ 
		            	e.target.cost = newcost;
		            	pq.add(e.target);  
		            }
		        }
		    } 
		}
		Vertex result = vertices.get(end);
		return result.cost;
	}
	
	public void print(){
		for (String key : vertices.keySet()) {
		     System.out.println("Key: " + key + ". Value: " + vertices.get(key).str());
		     vertices.get(key).print();
		     System.out.println();
		}
	}
	
	public int tripsMaxDistance(String start, String end, int distance){
		Vertex begin = vertices.get(start);
		if(begin == null)
			return 0;
		int count = 0;
		for(Edge e: begin.edges){
			if(distance - e.cost > 0)
				count += distanceToTarget(e.target, end, distance - e.cost());
		}
		return count;
	}
	private int distanceToTarget(Vertex start, String end, int distance){
		if(distance <= 0){
			return 0;
		}
		else{
			int count = 0;
			if(start.str().equals(end)){
				count++;
			}
			for(Edge e : start.edges){
				count += distanceToTarget(e.target,end, distance- e.cost());
			}
			return count;
		}
	}
}
