import java.io.*;
import java.util.*;

//My version of a dynamic stack
public class Stack{
	static int stack[]=new int[10];
	static int top=0;
	static boolean isFull(){
		if(top==stack.length)
			return true;
		return false;
	}
	static boolean isEmpty(){
		if(top==0)
			return true;
		return false;
	}
	static void increaseCapacity(){
		int temp[]=new int[stack.length*2];
		for(int i=0;i<top;i++){
			temp[i]=stack[i];
		}
		stack=temp;
	}
	static void push(int elem){
		if(isFull()){
			increaseCapacity();
		}
		stack[top++]=elem;
	}
	static int pop(){
		if(isEmpty()){
			System.out.println("Stack is Empty");
			return Integer.MIN_VALUE;
		}
		top--;
		return stack[top];
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		//PrintWriter pw=new PrintWriter(System.out);
		int op=0;
		System.out.println("Options\n(1)Press 1:To enter new Element\n(2)Press 2 to pop last element\n(3)Exit\n");
		outer:while(true){
			System.out.print("Enter your option :: ");
			op=sc.nextInt();
			switch(op){
				case 1:System.out.println("Enter the element to be inserted :: ");
						int elem = sc.nextInt();
						push(elem);
						break;
				case 2:int del = pop();
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

//Java Already has a class for stacks - The Stack Class
//Stack<E> s=new Stack<E>();
//s.push(E item);
//s.pop() - return E last;
//s.peek(); - return element at the top of stack
//s.search() - returns a 1 based position of the element

//One can also implement stack using ArrayList<E>,LinkedList<E> or Vector<E>