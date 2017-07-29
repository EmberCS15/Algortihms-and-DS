import java.util.*;
import java.io.*;


//Given an array find the sum of elements from [l,r]
public class SquareRootDecomp{
	static int RangeSum(int l,int r,int sqr[],int ar[],int n){
		int left = (int)Math.ceil(l/Math.sqrt(n));
		int right = (int)Math.floor(r/Math.sqrt(n));
		int sum = 0;
		int i=0;
		while(l%(int)Math.sqrt(n)!=0){
			sum+=ar[l];
			l++;
		}
		while(l+(int)Math.sqrt(n)<r){
			sum += sqr[l/(int)Math.sqrt(n)];
			l+=(int)Math.sqrt(n);
		}
		while(l<=r){
			sum+=ar[l];
			l++;
		}
		return sum;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[n];
		int i,j=0;
		for(i=0;i<n;i++)
			ar[i]=sc.nextInt();
		int sqr[]=new int[(int)Math.ceil(Math.sqrt(n))];
		for(i=0;i<(int)Math.sqrt(n);i++){
			for(j=i*(int)Math.sqrt(n);j<(i+1)*(int)Math.sqrt(n);j++){
				sqr[i]+=ar[j];
			}
		}
		//O(root(n)^2) = O(n)
		while(j<n){
			sqr[i]+=ar[j];
			j++;
		}
		System.out.println("Enter the number of queries  and the queries");
		int q=sc.nextInt();
		for(int z=0;z<q;z++){
			int c=sc.nextInt();
			switch(c){
				case 1:int pt=sc.nextInt();
						int val = sc.nextInt();
						int pos = (int)Math.ceil(pt/Math.sqrt(n));
						sqr[pos]+=(val - ar[pt]);
						break;
				case 2:int l=sc.nextInt();
						int r=sc.nextInt();
						System.out.println("The Sum is :: "+RangeSum(l,r,sqr,ar,n));//O(3*sqrt(n)) = O(sqrt(n))
						break;
				default:System.out.println("Please Enter a valid option :: ");
						break;
			}
		}
	}
}

//The time complexity for Square root decomposition is O(sqrt(n))
//The Time for pre-processing is O(n)