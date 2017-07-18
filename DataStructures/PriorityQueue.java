import java.util.*;
import java.io.*;

//Creating a min priority PriorityQueue
public class PriorityQueue{
	static int size=0;
	static int Parent(int i){
		return (int)Math.floor(i/2);
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
	static int Minimum(int heap[]){
		return heap[1];
	}
	static void minheapify(int heap[],int i){
		int left = Left(i);
		int right = Right(i);
		int largest=i;
		if(left<=size && heap[left]<heap[i])
			largest=left;
		else largest=i;
		if(right<=size && heap[right]<heap[largest])
			largest=right;
		if(largest!=i){
			swap(heap,i,largest);
			minheapify(heap,largest);
		}
	}
	static int ExtractMinimum(int heap[]){
		if(size<=0){
			System.out.println("Heap size underflow");
			return Integer.MIN_VALUE;
		}
		swap(heap,1,size);
		int min=heap[size];
		size--;
		minheapify(heap,1);
		return min;
	}
	static void decreaseKey(int heap[],int key,int i){
		if(heap[i]<key){
			System.out.println("Key is larger then the current value");
			return;
		}
		heap[i]=key;
		while(i>=1 && heap[Parent(i)]>heap[i]){
			swap(heap,Parent(i),i);
			i=Parent(i);
		}
	}
	static void insertKey(int heap[],int key){
		if(size == heap.length-1){
			System.out.println("Heap is full");
			return;
		}
		size++;
		heap[size]=Integer.MAX_VALUE;
		//Use the decrease key operation to place the key in the right place
		decreaseKey(heap,key,size);
	}
	static void display(int heap[]){
		for(int x:heap){
			System.out.print(x+" ");
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int heap[]=new int[n+1];
		int key=0;
		System.out.println("Options\n1.InsertElement\n2.DecreaseKey\n3.ExtractMinimum\n4.PeekMinimum\n5.Display\n6.Exit");
		while(true){
			System.out.println("Enter an option :: ");
			int op=sc.nextInt();
			switch(op){
				case 1:key=sc.nextInt();
						insertKey(heap,key);
						break;
				case 2:int index = sc.nextInt();
						key=sc.nextInt();
						decreaseKey(heap,key,index);
						break;
				case 3:int min = ExtractMinimum(heap);
						System.out.println("Minimum Extracted = "+min+" size = "+size);
						break;
				case 4:System.out.println("The current minimum = "+Minimum(heap));
						break;
				case 5:System.out.println("Displaying heap -- ");
						display(heap);
						break;
				case 6:System.out.println("Exiting.....");
						return;
				default:System.out.println("Please enter a valid option");
						break;
			}
		}
	}
}

//Time complexities - 
//insertKey - O(lgn)
//decreaseKey - O(lgn)
//ExtractMin - O(lgn)
//Minimum - O(1)
