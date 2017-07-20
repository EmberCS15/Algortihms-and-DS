import java.io.*;
import java.util.*;

//This is the set based implementation of dijkstra. It is relatively easier to code in java then the PriorityQeuue version.
//TreeSet implementation is based on a red black tree.
public class Dijkstra{
	static class Data{
		int v;
		int weight;
		public Data(int v,int weight){
			this.v=v;
			this.weight=weight;
		}
		public String toString(){
			return this.v+" "+this.weight;
		}
	}
	static void DijkstraPath(ArrayList<Data> graph[],int n,int src){
		int dist[]=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[src]=0;
		TreeSet<Data> heap=new TreeSet<Data>(new Comparator<Data>(){
			@Override
			public int compare(Data d1,Data d2){
				if(d1.weight == d2.weight){
					return d1.v-d2.v;
				}
				else return d1.weight-d2.weight;
			}
		});
		heap.add(new Data(src,0));
		while(heap.size() != 0){
			Data minData = heap.pollFirst();
			int u=minData.v;
			for(Data data:graph[u]){
				int v=data.v;
				int w=data.weight;
				if(dist[v]>dist[u]+w){
					heap.remove(new Data(v,dist[v]));
					dist[v]=dist[u]+w;
					heap.add(new Data(v,dist[v]));
				}
			}
		}
		System.out.println("Shortest path from src are as follows :: ");
		for(int i=1;i<dist.length;i++){
			System.out.println(i+" ~> "+dist[i]);
		}
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
		for(i=1;i<=m;i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
			int weight=sc.nextInt();
			graph[u].add(new Data(v,weight));
			graph[v].add(new Data(u,weight));
		}
		System.out.println("Enter the source :: ");
		int src=sc.nextInt();
		DijkstraPath(graph,n+1,src);
	}
}

//Time Complexity O(V+ELgV) ~ O(E*Lg(V))