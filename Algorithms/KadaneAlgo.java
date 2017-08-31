import java.util.*;
import java.io.*;

public class KadaneAlgo{
	static int Kadane(int ar[],int l,int r,int n){
		int maxSum=ar[0];
		int itr = 1;
		int maxTillHere = 0;
		int start = 0;
		int end = 0;
		int fstart = 0;
		int f = 0;
		for(itr=0;itr<n;itr++){
			maxTillHere+=ar[itr];
			if(maxTillHere<0){
				start = itr+1;
				maxTillHere=0;
				continue;
			}
			if(maxTillHere > maxSum){
				f=1;
				maxSum=Math.max(maxSum,maxTillHere);
				end = itr;
				fstart = start;
			}
		}
		if(f==1)
			System.out.println("Start = "+start+" End = "+end);
		else System.out.println("Start = 0 End = 0");
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