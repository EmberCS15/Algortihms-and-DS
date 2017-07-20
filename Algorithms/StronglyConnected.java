//Strongly Connected Componenets

import java.io.*;
import java.util.*;

public class StronglyConnected{
	static LinkedList<Integer> list=new LinkedList<Integer>();
	static int finish=1;
	static void exploreGraph(ArrayList<Integer> graph[],int u,boolean mark[]){
		mark[u]=true;
		for(int v:graph[u]){
			if(!mark[v]){
				exploreGraph(graph,v,mark);
			}
		}
		System.out.println("Ended Traversing :: "+u);
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
	static void exploreReverseGraph(ArrayList<Integer> graphR[],int u,boolean mark[],ArrayList<Integer> nodes){
		mark[u]=true;
		nodes.add(u);
		for(int v:graphR[u]){
			if(!mark[v]){
				exploreReverseGraph(graphR,v,mark,nodes);
			}
		}
	}
	static void ReverseGraphDFS(ArrayList<Integer> graphR[],int n){
		boolean mark[]=new boolean[n];
		for(int u:list){
			ArrayList<Integer> nodes=new ArrayList<Integer>();
			if(!mark[u]){
				exploreReverseGraph(graphR,u,mark,nodes);
				System.out.println("\nStrongly Connected :: ");
				for(int s:nodes)
					System.out.print(s+" ");
			}
		}
	}
	static void StrongComponent(ArrayList<Integer> graph[],ArrayList<Integer> graphR[],int n){
		DFS(graph,n);
		ReverseGraphDFS(graphR,n);
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i=0;
		@SuppressWarnings("unchecked")
		ArrayList<Integer> graph[]=(ArrayList<Integer>[])new ArrayList<?>[n+1];
		@SuppressWarnings("unchecked")
		ArrayList<Integer> graphR[]=(ArrayList<Integer>[])new ArrayList<?>[n+1];
		for(i=0;i<n+1;i++){
			graphR[i]=new ArrayList<Integer>();
			graph[i]=new ArrayList<Integer>();
		}
		int m=sc.nextInt();
		for(i=0;i<m;i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
			graph[u].add(v);
			graphR[v].add(u);
		}
		StrongComponent(graph,graphR,n+1);
		sc.close();
	}
}
//Time Complexity - O(V+E)