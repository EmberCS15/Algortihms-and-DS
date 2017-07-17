import java.util.*;
import java.io.*;

public class KadaneAlgo{
	static int Kadane(int ar[],int l,int r,int n){
		int maxSum=ar[0];
		int itr = 1;
		int maxTillHere = ar[0];
		for(itr=1;itr<n;itr++){
			maxTillHere+=ar[itr];
			if(maxTillHere<=0)
				maxTillHere=0;
			maxSum=Math.max(maxSum,maxTillHere);
		}
		return maxSum;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int n=sc.nextInt();
		int ar[]=new int[n];
		int i;
		for(i=0;i<n;i++)
			ar[i]=sc.nextInt();
		int maxSum=Kadane(ar,0,ar.length-1,ar.length);//O(n)
		pw.println("The maximum Subarray Sum is :: "+maxSum);
		pw.close();
	}
}

//Time Complexity is :: O(n)