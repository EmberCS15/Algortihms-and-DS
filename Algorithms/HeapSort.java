import java.io.*;
import java.util.*;

public class HeapSort{
	//to maintain the size of the heap
	static int size = 0;
	static int Parent(int i){
		return (int)Math.floor(i);
	}
	static int Left(int i){
		return 2*i;
	}
	static int Right(int i){
		return 2*i+1;
	}
	static void swap(int heap[],int i,int j){
		int t=heap[i];
		heap[i]=heap[j];
		heap[j]=t;
	}
	static void maxheapify(int heap[],int i){
		int left = Left(i);
		int right = Right(i);
		int largest=heap[i];
		if(left<=size && heap[left]>heap[i])
			largest = left;
		else largest=i;
		if(right<=size && heap[right]>heap[largest]){
			largest = right;
		}
		if(largest!=i){
			swap(heap,largest,i);
			maxheapify(heap,largest);
		}
	}
	static void buildHeap(int heap[]){
		int len = (int)Math.floor(size/2);
		//Iterating from len down to 1
		for(int i=len;i>=1;i--){//O(n)
			maxheapify(heap,i);//O(lgn)
		}
	}
	static void heapSort(int heap[]){
		size = heap.length-1;
		buildHeap(heap);//O(nlgn)
		//For each largest element heap[1] take it towards the last to get a sorted array
		for(int i=heap.length-1;i>=2;i--){//O(n)
			swap(heap,1,i);
			size--;
			maxheapify(heap,1);
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int heap[]=new int[n+1];
		for(int i=1;i<=n;i++)
			heap[i]=sc.nextInt();
		heapSort(heap);
		System.out.println("The sorted array is :: ");
		for(int x:heap){
			System.out.print(x+" ");
		}
	}	
}


//Time complexity - nlgn+n = O(nlgn)