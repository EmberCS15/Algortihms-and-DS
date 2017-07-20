import java.util.*;
import java.io.*;

public class Kruskal{
	static class Data{
		int u;
		int v;
		int weight;
		public Data(int u,int v,int weight){
			this.u=u;
			this.v=v;
			this.weight=weight;
		}
	}
	static void Union(int parent[],int p1,int p2){
		parent[p2]=p1;
	}
	static int FindParent(int parent[],int u){
		while(parent[u]!=-1){
			u=parent[u];
		}
		return u;
	}
	static void MSTKruskal(ArrayList<Data> edges,int parent[],int n){
		int total = 0;
		for(Data data:edges){
			int u=data.u;
			int v=data.v;
			int weight=data.weight;
			int p1=FindParent(parent,u);
			int p2=FindParent(parent,v);
			if(p1!=p2){
				total+=weight;
				Union(parent,p1,p2);
			}
		}
		System.out.println("The minimum Spanning tree-weight :: "+total);
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<Data> edges=new ArrayList<Data>();
		int m=sc.nextInt();
		int i=0;
		for(i=1;i<=m;i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
			int w=sc.nextInt();
			edges.add(new Data(u,v,w));
		}
		Collections.sort(edges,new Comparator<Data>(){
			@Override
			public int compare(Data d1,Data d2){
				return d1.weight-d2.weight;
			}
		});
		int parent[]=new int[n+1];
		Arrays.fill(parent,-1);
		MSTKruskal(edges,parent,n+1);
	}
}

/*
Time Complexity of Set operations = 1)FindParent - O(n)
									2)Union - O(1)

Time Complexity of Kruskal - 1)O(ElgV)

In the for loop of the operation Takes O(V) time and Disjoint set operation of FindParent takes O(lgV) time.
Please check out the time complexities of the disjoint set operations
*/