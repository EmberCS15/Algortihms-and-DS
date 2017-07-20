import java.io.*;
import java.util.*;

//This is the set based implementation of dijkstra. It is relatively easier to code in java then the PriorityQeuue version.
//TreeSet implementation is based on a red black tree.
public class Prim{
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
		boolean mark[]=new boolean[n];
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
			mark[u]=true;
			for(Data data:graph[u]){
				int v=data.v;
				int w=data.weight;
				if(!mark[v] && dist[v]>w){
					heap.remove(new Data(v,dist[v]));
					dist[v]=w;
					heap.add(new Data(v,dist[v]));
				}
			}
		}
		int total=0;
		for(int i=1;i<dist.length;i++){
			total+=dist[i];
		}
		System.out.print("The MST weight :: "+total);
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
		DijkstraPath(graph,n+1,1);
	}
}

//Time Complexity O(V+ELgV) ~ O(E*Lg(V))