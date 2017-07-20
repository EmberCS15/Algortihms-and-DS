import java.io.*;
import java.util.*;

//It has been implemented for directed graph
//Transitive Closure uses FloydWarshall to see if a path exists between i and j for all vertex pairs (i,j) in set V
public class TransitiveClosure{
	static void printMatrix(int adjMatrix[][],int n){
		for(int i=1;i<n;i++){
			for(int j=1;j<n;j++){
				System.out.print(adjMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void Closure(int adjMatrix[][],int n){
		for(int k=1;k<n;k++){
			for(int i=1;i<n;i++){
				for(int j=1;j<n;j++){
					adjMatrix[i][j]=(adjMatrix[i][j])| (adjMatrix[i][k]&adjMatrix[k][j]);
				}
			}
		}
		System.out.println("The all pair Transitive Closure is :: ");
		printMatrix(adjMatrix,n);
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int adjMatrix[][]=new int[n+1][n+1];
		int i,j;
		for(i=1;i<n+1;i++){
			for(j=1;j<n+1;j++){
				if(i==j)
					adjMatrix[i][j]=1;
				else adjMatrix[i][j]=0;
			}
		}
		int m=sc.nextInt();
		for(i=1;i<=m;i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
			adjMatrix[u][v]=1;
			//uncomment this to make graph undirected
			//adjMatrix[v][u]=1;
		}
		//printMatrix(adjMatrix,n+1);
		Closure(adjMatrix,n+1);
		sc.close();
	}
}

//Time Complexity is O(n^3)
/*
In flloyd Warshall we simply for each node k if it is the intermediate node between i -> j does the shortest distance change.
*/