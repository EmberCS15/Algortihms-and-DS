/*
Whereas counting sort assumes that the input
consists of integers in a small range, bucket sort assumes that the input is generated
by a random process that distributes elements uniformly and independently over
the interval (0,1].

Conditions for bucket sort - 0<A[i]<=1
1. It divides the interval(0,1] into n lists which are also called buckets.
2. It places each element into one of these lists.
3. The lists are then sorted indivisually and then listed in order

Time complexity - Linear
*/

import java.io.*;
import java.util.*;

public class BucketSort{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		float ar[]=new float[n];
		int i;
		@SuppressWarnings("unchecked")
		ArrayList<Float> list[]=(ArrayList<Float>[])new ArrayList<?>[n];
		for(i=0;i<n;i++){
			ar[i]=sc.nextFloat();
			list[i]=new ArrayList<Float>();
		}
		//important step
		for(i=0;i<n;i++){
			int pos = (int)Math.floor(n*ar[i]);
			list[pos].add(ar[i]);
		}
		for(i=0;i<n;i++){
			Collections.sort(list[i]);
			//Use insertion sort to sort the list in practise
		}
		System.out.println("The sorted array is :: ");
		for(i=0;i<n;i++){
			for(Float x:list[i])
				System.out.print(x+" ");
		}
	}
}