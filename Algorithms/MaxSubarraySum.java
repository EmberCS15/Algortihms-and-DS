import java.util.*;
import java.io.*;

public class MaxSubarraySum{
	static int MaximumCrossingSum(int ar[],int l,int mid,int r){
		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		int sum=0;
		int i;
		for(i=mid;i>=l;i--){
			sum+=ar[i];
			if(sum>leftSum)
				leftSum=sum;
		} 
		sum=0;
		for(i=mid+1;i<=r;i++){
			sum+=ar[i];
			if(sum>rightSum)
				rightSum=sum;
		}
		return leftSum+rightSum;
	}
	static int MaximumSubArraySum(int ar[],int l,int r){
		if(l>r)
			return 0;
		if(l==r){
			return ar[l];
		}
		int mid=(l+r)/2;
		int leftSum = MaximumSubArraySum(ar,l,mid);
		int rightSum = MaximumSubArraySum(ar,mid+1,r);
		int centerSum = MaximumCrossingSum(ar,l,mid,r);
		int max=Math.max(leftSum,rightSum);
		max=Math.max(max,centerSum);
		return max;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int n=sc.nextInt();
		int ar[]=new int[n];
		int i;
		for(i=0;i<n;i++)
			ar[i]=sc.nextInt();
		int maxSum = MaximumSubArraySum(ar,0,ar.length-1);
		pw.println("The maximum Subarray Sum is :: "+maxSum);
		pw.close();
	}
}

//Divide and Conquer
/*Time Complexity - T(n)=2*T(n/2)+O(n)
T(n)= nlg(n)
*/