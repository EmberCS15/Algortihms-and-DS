//Topological sort is only possible for a directed acyclic graph or DAG

import java.io.*;
import java.util.*;

public class TopologicalSort{
	static LinkedList<Integer> list=new LinkedList<Integer>();
	static int finish=1;
	static void exploreGraph(ArrayList<Integer> graph[],int u,boolean mark[]){
		mark[u]=true;
		for(int v:graph[u]){
			if(!mark[v]){
				exploreGraph(graph,v,mark);
			}
		}
		//System.out.println("Ended Traversing :: "+u);
		//As soon as we finish exploring the graph using this vertex add it to the start of the list
		list.addFirst(u);
	}
	static void DFS(ArrayList<Integer> graph[],int n){
		boolean mark[]=new boolean[n];
		int u=0;
		for(u=1;u<n;u++){
			if(!mark[u]){
				exploreGraph(graph,u,mark);
			}
		}
	}
	static void Topological(ArrayList<Integer> graph[],int n){
		DFS(graph,n);
		System.out.println("Printing the topological Sort :: ");
		for(int v:list)
			System.out.print(v+" ");
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i=0;
		@SuppressWarnings("unchecked")
		ArrayList<Integer> graph[]=(ArrayList<Integer>[])new ArrayList<?>[n+1];
		for(i=0;i<n+1;i++)
			graph[i]=new ArrayList<Integer>();
		int m=sc.nextInt();
		for(i=0;i<m;i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
			graph[u].add(v);
		}
		Topological(graph,n+1);
		sc.close();
	}
}

//Time Complexity = Time Complexity of DFS = O(V+E)