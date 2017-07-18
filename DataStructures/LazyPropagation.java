import java.io.*;
import java.util.*;

//Updating a ranege only when required
public class LazyPropagation{
	static int tree[];
	static int lazy[];
	static void buildTree(int ar[],int start,int end,int node){
		if(start==end){
			tree[node] = ar[start];
			return;
		}
		int mid=(start+end)/2;
		buildTree(ar,start,mid,2*node);
		buildTree(ar,mid+1,end,2*node+1);
		tree[node]=tree[2*node]+tree[2*node+1];
	}
	static void updateRange(int l,int r,int start,int end,int node,int val){
		if(lazy[node]!=0){
			tree[node]+=(end-start+1)*lazy[node];
			if(start!=end){
				lazy[2*node]+=lazy[node];
				lazy[2*node+1]+=lazy[node];
			}
			lazy[node]=0;
		}
		if(start>end || start>r || end<l)
			return;
		if(start>=l && end<=r){
			tree[node]+=(end-start+1)*val;
			if(start!=end){
				lazy[2*node]+=val;
				lazy[2*node+1]+=val;
			}
			return;
		}
		int mid=(start+end)/2;
		updateRange(l,r,start,mid,2*node,val);
		updateRange(l,r,mid+1,end,2*node+1,val);
		tree[node]=tree[2*node]+tree[2*node+1];
	}
	static int queryRange(int l,int r,int start,int end,int node){
		if(start>r || end<l)
			return 0;
		if(lazy[node]!=0){
			tree[node]+=(end-start+1)*lazy[node];
			if(start!=end){
				lazy[2*node]+=lazy[node];
				lazy[2*node+1]+=lazy[node];
			}
			lazy[node]=0;
		}
		if(start>=l && end<=r){
			return tree[node];
		}
		int mid=(start+end)/2;
		int p1=queryRange(l,r,start,mid,2*node);
		int p2=queryRange(l,r,mid+1,end,2*node+1);
		return (p1+p2);
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[n+1];
		int i;
		for(i=1;i<n+1;i++){
			ar[i]=sc.nextInt();
		}
		tree = new int[4*n];
		lazy=new int[4*n];
		buildTree(ar,1,n,1);
		System.out.print("Enter the number of Queries :: ");
		int m=sc.nextInt();
		System.out.println("Options\n1.Query value in a range[l,r]\n2.UpdateRange from l to r");
		for(i=0;i<m;i++){
			int c=sc.nextInt();
			switch(c){
				case 1:int l=sc.nextInt();
						int r=sc.nextInt();
						System.out.println("The value of sum of all elements in this interval = "+queryRange(l,r,1,n,1));
						break;
				case 2:int lf=sc.nextInt();
						int rt=sc.nextInt();
						int val=sc.nextInt();
						for(int j=lf;j<rt;j++){
							ar[j]+=val;
						}
						updateRange(lf,rt,1,n,1,val);
						break;
			}
		}
	}
}