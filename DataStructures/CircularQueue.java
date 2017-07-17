import java.io.*;
import java.util.*;

public class CircularQueue{
	static int queue[];
	static int tail=-1;
	static int head=-1;
	static boolean isFull(){
		if((tail==head-1) || (head==0 && tail==queue.length-1)) 
			return true;
		return false;
	}
	static boolean isEmpty(){
		if(head==-1){
			return true;
		}
		return false;
	}
	static void enqueue(int elem){
		if(isFull()){
			System.out.println("Queue is full");
			return;
		}
		if(tail==-1 && head==-1)
			tail=head=0;
		else if(tail == queue.length-1)
			tail=0;
		else tail++;
		queue[tail]=elem;
	}
	static int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
			return Integer.MIN_VALUE;
		}
		int p=queue[head];
		if(head==tail){
			head=tail=-1;
		}else if(head==queue.length-1){
			head=0;
		}else head++;
		return p;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		//PrintWriter pw=new PrintWriter(System.out);
		System.out.println("Enter the size of the Circular queue");
		int size = sc.nextInt();
		queue=new int[size];
		int op=0;
		System.out.println("Options\n(1)Press 1:To enter new Element\n(2)Press 2 to pop first element\n(3)Exit\n");
		outer:while(true){
			System.out.print("Enter your option :: ");
			op=sc.nextInt();
			switch(op){
				case 1:System.out.println("Enter the element to be inserted :: ");
						int elem = sc.nextInt();
						enqueue(elem);
						break;
				case 2:int del = dequeue();
						if(del != Integer.MIN_VALUE)
							System.out.println("Popped :: "+del);
						break;
				case 3:System.out.println("Exiting...");
						return;
				default:System.out.println("Please enter a valid option :: ");
						continue outer;
			}
		}
		//pw.close();
	}
}
