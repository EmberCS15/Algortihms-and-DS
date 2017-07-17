import java.io.*;
import java.util.*;

public class Queue{
	static int queue[];
	static int tail=0;
	static int head=0;
	static boolean isFull(){
		if(tail==queue.length)
			return true;
		return false;
	}
	static boolean isEmpty(){
		if(head>=tail){
			head=tail=0;
			return true;
		}
		return false;
	}
	static void enqueue(int elem){
		if(isFull()){
			System.out.println("Queue is full");
			return;
		}
		queue[tail++]=elem;
	}
	static int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
			return Integer.MIN_VALUE;
		}
		return queue[head++];
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		//PrintWriter pw=new PrintWriter(System.out);
		System.out.println("Enter the size of the queue");
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
