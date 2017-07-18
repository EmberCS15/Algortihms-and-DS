import java.io.*;
import java.util.*;

/*We have an array arr[0 . . . n-1]. We should be able to
1 Find the sum of elements from index l to r where 0 <= l <= r <= n-1

2 Change value of a specified element of the array to a new value x. We need to do arr[i] = x where 0 <= i <= n-1.
*/
public class SegmentTree{
	static int tree[];
	static void buildTree(int ar[],int left,int right,int node){
		if(left==right){
			tree[node]=ar[left];
			return;
		}
		int mid=(left+right)/2;
		buildTree(ar,left,mid,2*node);
		buildTree(ar,mid+1,right,2*node+1);
		tree[node]=tree[2*node]+tree[2*node+1];
	}
	static int queryTree(int l,int r,int start,int end,int node){
		if(end<l || start>r){
			return 0;
		}
		if(start>=l && end<=r){
			return tree[node];
		}
		int mid=(start+end)/2;
		int p1=queryTree(l,r,start,mid,2*node);
		int p2=queryTree(l,r,mid+1,end,2*node+1);
		return (p1+p2);
	}
	//It can also be done with lazy propagation when a complete range is being updated
	//Update is critical whenever we change any element
	static void updateTree(int val,int start,int end,int indx,int node){
		if(start == end){
			tree[node]+=val;
			return;
		}
		int mid = (start+end)/2;
		if(start<=indx && indx<=mid){
			updateTree(val,start,mid,indx,2*node);
		}else if(mid<indx && indx<=end){
			updateTree(val,mid+1,end,indx,2*node+1);
		}
		tree[node]=tree[2*node]+tree[2*node+1];
	}
	static void updateRange(int ar[],int node,int l,int r,int start,int end,int val){
		if(end<l || start>r)
			return;
		if(end==start){
			ar[start]+=val;
			tree[node]+=val;
			return;
		}
		int mid=(start+end)/2;
		updateRange(ar,2*node,l,r,start,mid,val);
		updateRange(ar,2*node+1,l,r,mid+1,end,val);
		tree[node]=tree[2*node]+tree[2*node+1];
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
		buildTree(ar,1,n,1);
		System.out.println("Enter the number of queries");
		int m=sc.nextInt();
		System.out.println("Options\n1.Query value in a range[l,r]\n2.Update an index\n3.UpdateRange from l to r");
		for(i=0;i<m;i++){
			int c=sc.nextInt();
			switch(c){
				case 1:int l=sc.nextInt();
						int r=sc.nextInt();
						System.out.println("The value of sum of all elements in this interval = "+queryTree(l,r,1,n,1));
						break;
				case 2:int indx=sc.nextInt();
						int key=sc.nextInt();
						ar[indx]+=key;
						updateTree(key,1,n,indx,1);
						System.out.println("Updated..");
						break;
				case 3:int lf=sc.nextInt();
						int rt=sc.nextInt();
						int val=sc.nextInt();
						updateRange(ar,1,lf,rt,1,n,val);
			}
		}
	}
}

//Time Complexities - 
//QueryTree - O(lgn)
//buildTree tree - O(n)
//updateTree - O(lgn)