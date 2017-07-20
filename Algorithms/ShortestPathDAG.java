//Computing Shortest Path in a DAG
//Do topological sort
//In the topologically sorted manner just extract vertices and relax the connected edges

//Topological sort is only possible for a directed acyclic graph or DAG

import java.io.*;
import java.util.*;

public class ShortestPathDAG{
	static LinkedList<Integer> list=new LinkedList<Integer>();
	static int finish=1;
	static class Data{
		int node;
		int weight;
		public Data(int node,int weight){
			this.node=node;
			this.weight=weight;
		}
	}
	static void Relax(int dist[],int u,int v,int w){
		if(dist[u]==Integer.MAX_VALUE)
			return;
		if(dist[v]>dist[u]+w){
			dist[v]=dist[u]+w;
		}
	}
	static void exploreGraph(ArrayList<Data> graph[],int u,boolean mark[]){
		mark[u]=true;
		for(Data data:graph[u]){
			int v=data.node;
			if(!mark[v]){
				exploreGraph(graph,v,mark);
			}
		}
		System.out.println("Ended Traversing :: "+u);
		//As soon as we finish exploring the graph using this vertex add it to the start of the list
		list.addFirst(u);
	}
	static void DFS(ArrayList<Data> graph[],int n){
		boolean mark[]=new boolean[n];
		int u=0;
		for(u=1;u<n;u++){
			if(!mark[u]){
				exploreGraph(graph,u,mark);
			}
		}
	}
	static void Topological(ArrayList<Data> graph[],int n,int src){
		DFS(graph,n);
		int dist[]=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[src]=0;
		for(int u:list){
			for(Data data:graph[u]){
				Relax(dist,u,data.node,data.weight);
			}
		}
		System.out.println("Computing the shortest distance :: ");
		for(int i=1;i<n;i++)
			System.out.println(i+" "+dist[i]);
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i=0;
		@SuppressWarnings("unchecked")
		ArrayList<Data> graph[]=(ArrayList<Data>[])new ArrayList<?>[n+1];
		for(i=0;i<n+1;i++)
			graph[i]=new ArrayList<Data>();
		int m=sc.nextInt();
		for(i=0;i<m;i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
			int w=sc.nextInt();
			graph[u].add(new Data(v,w));
		}
		System.out.println("Enter the source :: ");
		int src=sc.nextInt();
		Topological(graph,n+1,src);
		sc.close();
	}
}

//Time Complexity = O(V+E)