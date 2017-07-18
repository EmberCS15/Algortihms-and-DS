import java.io.*;
import java.util.*;

public class CountSort{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int A[]=new int[n];
		int max=Integer.MIN_VALUE;
		int i;
		for(i=0;i<n;i++){
			A[i]=sc.nextInt();
			max=Math.max(max,A[i]);
		}
		int B[]=new int[max+1];
		for(i=0;i<n;i++){
			B[A[i]]++;
		}
		for(i=1;i<max+1;i++){
			B[i]=B[i]+B[i-1];
		}
		int C[]=new int[n+1];
		for(i=0;i<n;i++){
			C[B[A[i]]]=A[i];
			B[A[i]]--;
		}
		System.out.println("The Sorted array is :: ");
		for(int x:C)
			System.out.print(x+" ");
	}
}

//Time complexity O(k+n) if k(here max) is small then it is a good choice
/*
Read Radix Sort from any source.
digitplace- 321

numbers = 	560
			234
			908
			435
			222
			253
			789
given n d-digit numbers radix sort is simply applying a stable sort such as count sort on each digit place
from 1 to d

Algo- for i=1 to d:
		Sort the values according to the ith digit using a stable sort.

Time complexity - O(d(n+k)) which can be proved to be equal to O(n+k).

*/
