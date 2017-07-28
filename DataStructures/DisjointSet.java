import java.util.*;
import java.io.*;

public class DisjointSet{
	static class Node{
		private int rank;
		private int data;
		private Node parent;
		public Node(int data,int rank,Node parent){
			this.data=data;
			this.parent=parent;
			this.rank=rank;
		}
		public int getRank(){
			return this.rank;
		}
		public void setRank(int r){
			this.rank = r;
		}
		public Node getParent(){
			return this.parent;
		}
		public void setParent(Node parent){
			this.parent=parent;
		}
		public String toString(){
			return ""+this.data;
		}
	}
	static Node FindSet(Node u){//O(1+lgn)
		if(u.getParent() == null)
			return u;
		//Path Compression
		u.setParent(FindSet(u.getParent()));
		//System.out.println(" u = "+u.toString());	
		return u.getParent();
	}
	static void Union(Node u,Node v){
		Link(FindSet(u),FindSet(v));//Union By rank
	} 
	static void Link(Node u,Node v){
		if(u.getRank()>v.getRank()){
			v.setParent(u);
		}else u.setParent(v);
		if(u.getRank() == v.getRank()){
			v.setRank(v.getRank()+1);
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[n];
		Node set[]=new Node[n];
		int i;
		for(i=0;i<n;i++){
			ar[i]=sc.nextInt();
			Node node = new Node(ar[i],0,null);
			set[i]=node;
		}
		int u,v;
		System.out.println("Options\n1.Union\n2.FindSet\n3.Exit");
		while(true){
			System.out.println("Enter your options :: ");
			int choice = sc.nextInt();
			switch(choice){
				//u and v are indices of the elements
				case 1:u=sc.nextInt();
						v=sc.nextInt();
						Union(set[u],set[v]);
						System.out.println("Union Performed");
						break;
				case 2:u=sc.nextInt();
						System.out.println("The Parent is :: "+FindSet(set[u]).toString());
						break;
				case 3:System.out.println("Exiting.......");
						return;
			}
		}

	}
}

/*When we use both union by rank and path compression, the worst-case running
time is O(mf(n)) where f(n) is a very slowly growing function . In any conceivable application of a disjoint-set 
data structure, f(n)<=4; thus, we can view the running time as linear in m in all practical situa-
tions. Strictly speaking, however, it is superlinear.*/
//Disjoint Sets can be used for Creating LCA Algorithms