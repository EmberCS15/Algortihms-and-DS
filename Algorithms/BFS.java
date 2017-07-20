import java.io.*;
import java.util.*;

public class BFS{
	static void BreadthFirstSearch(ArrayList<Integer> graph[],int levels[],int size,int src){
		levels[src]=0;
		//Creating the parent array
		int parent[]=new int[size];
		boolean mark[]=new boolean[size];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.addFirst(src);
		mark[src]=true;
		parent[src]=-1;
		while(queue.size()!=0){ // O(E)
			int u=queue.pollFirst();
			for(int v:graph[u]){ //O(V)
				if(!mark[v]){
					queue.addLast(v);
					mark[v]=true;
					parent[v]=u;
					levels[v]=levels[u]+1;	
				}
			}
		}
		System.out.println("Printing the levels :: ");
		for(int i=1;i<size;i++){
			System.out.println("Node : "+i+" --- Level : "+levels[i]);
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i=0;
		@SuppressWarnings("unchecked")
		ArrayList<Integer> graph[]=(ArrayList<Integer>[])new ArrayList<?>[n+1];
		for(i=0;i<n+1;i++){
			graph[i]=new ArrayList<Integer>();
		}
		int m=sc.nextInt();
		for(i=0;i<m;i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
			graph[u].add(v);
			graph[v].add(u);
		}
		System.out.println("Specify the source :: ");
		int src=sc.nextInt();
		int levels[]=new int[n+1];
		BreadthFirstSearch(graph,levels,n+1,src);
	}
}

//Time Complexity - 
//Breadth First search Scans through all the edges and vertices in the adjacency list. So the time is equal
//to the time required to scan the entire list
//T(n)=O(V+E)