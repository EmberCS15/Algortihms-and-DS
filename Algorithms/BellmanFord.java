import java.util.*;
import java.io.*;

public class BellmanFord{
	static void Relax(int ar[][],int dist[],int u,int v){
		if(dist[u]==Integer.MAX_VALUE)
			return;
		if(dist[v]>dist[u]+ar[u][v]){
			if(dist[u]!=Integer.MAX_VALUE)
				dist[v]=dist[u]+ar[u][v];
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i,j,k;
		int ar[][]=new int[n+1][n+1];
		for(i=0;i<n+1;i++)
			Arrays.fill(ar[i],Integer.MIN_VALUE);
		int dist[]=new int[n+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		int m=sc.nextInt();
		for(i=0;i<m;i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
			int w=sc.nextInt();
			ar[u][v]=w;
			ar[v][u]=w;
		}
		System.out.println("Specify the Source :: ");
		int src=sc.nextInt();
		dist[src]=0;
		for(i=1;i<n;i++){
			for(j=1;j<n+1;j++){
				for(k=1;k<n+1;k++){
					if(ar[j][k]!=Integer.MIN_VALUE){
						//This means that an edge exists
						Relax(ar,dist,j,k);
					}
				}
			}
		}
		//Bellman Ford Algorithm works even for negative edges
		//Bellman ford Algorithm is used to detect negative weight cycle. Now we do the same here
		for(i=1;i<n+1;i++){
			for(j=1;j<n+1;j++){
				if(ar[i][j]!=Integer.MIN_VALUE){
					if(dist[j]>dist[i]+ar[i][j]){
						//This means the graph has a negative weight cycle
						System.out.println("The graph has a negative weight cycle so Shortest Path Cannot be computed");
						return;
					}
				}
			}
		}
		System.out.println("The Shortest paths :: ");
		for(i=1;i<n+1;i++)
			System.out.println(i+" -> "+dist[i]);
		sc.close();
	}
}

//O(n^3)
//Bellman ford algorithm can also work in terms of negative edges
//It can be used to detect a negative weight cycle in which case shorttest path cannot be computed