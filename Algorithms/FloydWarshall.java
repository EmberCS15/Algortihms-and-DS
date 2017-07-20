import java.io.*;
import java.util.*;

//It has been implemented for undirected graph
public class FloydWarshall{
	static void printMatrix(int adjMatrix[][],int n){
		for(int i=1;i<n;i++){
			for(int j=1;j<n;j++){
				System.out.print(adjMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void FloydWarshallPath(int adjMatrix[][],int n){
		for(int k=1;k<n;k++){
			for(int i=1;i<n;i++){
				for(int j=1;j<n;j++){
					if(adjMatrix[i][k]!=Integer.MAX_VALUE && adjMatrix[k][j]!=Integer.MAX_VALUE)
						adjMatrix[i][j]=Math.min(adjMatrix[i][j],adjMatrix[i][k]+adjMatrix[k][j]);
				}
			}
		}
		System.out.println("The all pair shortest path is :: ");
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
					adjMatrix[i][j]=0;
				else adjMatrix[i][j]=Integer.MAX_VALUE;
			}
		}
		int m=sc.nextInt();
		for(i=1;i<=m;i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
			int w=sc.nextInt();
			adjMatrix[u][v]=w;
			adjMatrix[v][u]=w;
		}
		printMatrix(adjMatrix,n+1);
		FloydWarshallPath(adjMatrix,n+1);
		sc.close();
	}
}

//Time Complexity is O(n^3)
/*
In flloyd Warshall we simply for each node k if it is the intermediate node between i -> j does the shortest distance change.
*/