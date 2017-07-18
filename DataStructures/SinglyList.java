import java.io.*;
import java.util.*;

class Node{
	private int value;
	private Node link;

	public Node(int value,Node link){
		this.value = value;
		this.link = link;
	}

	public void setValue(int v){
		this.value=v;
	}
	public int getValue(){
		return this.value;
	}
	public void setLink(Node n){
		this.link = n;
	}
	public Node getLink(){
		return this.link;
	}
}

class LinkList{
	private Node start;
	private Node end;
	private int size;
	public LinkList(){
		start=null;
		end=null;
		size=0;
	}
	public boolean isEmpty(){
		return (this.size==0);
	}
	public int getSize(){
		return this.size;
	}
	public void insertAtStart(int val){
		Node node = new Node(val,null);
		size++;
		if(start == null){
			start = node;
			end = node;
		}else{
			node.setLink(start);
			start = node;
		}
	}
	public void insertAtEnd(int val){
		Node node=new Node(val,null);
		size++;
		if(start == null){
			start = node;
			end = node;
		}else{
			end.setLink(node);
			end=node;
		}
	}
	public void insertAtPos(int val,int p){
		if(p<=0 || p>size){
			System.out.println("Please enter a valid value for position");
			return;
		}
		int pos=1;
		Node prevNode=start;
		while(prevNode.getLink()!=null && pos!=p){
			prevNode=prevNode.getLink();
			pos++;
		}
		Node nextNode = prevNode.getLink();
		Node node = new Node(val,null);
		prevNode.setLink(node);
		node.setLink(nextNode);
		size++;
	}
	public boolean searchElement(int val){
		Node node=start;
		while(node.getLink()!=null){
			if(node.getValue() == val){
				return true;
			}
			node=node.getLink();
		}
		return false;
	}
	public Node pollFirst(){
		Node node=start;
		start=start.getLink();
		size--;
		return node;
	}
	public Node pollLast(){
		Node node = start;
		while(node.getLink().getLink()!=null){
			node=node.getLink();
		}
		end = node;
		size--;
		return node.getLink();
	}
	public Node pollPos(int p){
		if(p<0 || p>size){
			System.out.println("Please enter a valid value for position");
			return null;
		}
		Node node=start;
		Node old=node;
		int pos=0;
		while(pos!=p){
			old=node;
			node=node.getLink();
			pos++;
		}
		old.setLink(node.getLink());
		size--;
		return node;
	}
	public void display(){
		Node node = start;
		while(node!=null){
			System.out.print(node.getValue()+" ");
			node=node.getLink();
		}
	}
}
public class SinglyList{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		LinkList list = new LinkList();
		int val=0;
		Node n=null;
		System.out.println("Options\n(0)Exit\n(1)InsertAtStart\n(2)InsertAtEnd\n(3)InsertAtPos\n(4)SearchList\n(5)PollFirst\n(6)PollLast\n(7)PollPos\n(8)GetSize\n(9)DisplayList");
		while(true){
			System.out.print("Please enter your choice :: ");
			int choice=sc.nextInt();
			switch(choice){
				case 0:System.out.println("Exiting.....");
						return;
				case 1:val=sc.nextInt();
						list.insertAtStart(val);
						break;
				case 2:val=sc.nextInt();
						list.insertAtEnd(val);
						break;
				case 3:val=sc.nextInt();
						int pos=sc.nextInt();
						list.insertAtPos(val,pos);
						break;
				case 4:val=sc.nextInt();
						if(list.searchElement(val))
							System.out.println("Element is present");
						else System.out.println("Element not present");
						break;
				case 5:n = list.pollFirst();
						System.out.println("Node value = "+n.getValue());
						break;
				case 6:n=list.pollLast();
						System.out.println("Node value = "+n.getValue());
						break;
				case 7:val=sc.nextInt();
						n=list.pollPos(val);
						System.out.println("Node value = "+n.getValue());
						break;
				case 8:System.out.println("Size of the list is :: "+list.getSize());
						break;
				case 9:list.display();
						break;
				default:System.out.println("Please enter a valid value");
						break;
			}
		}
	}
}

//Java Already has a generic class for linkedlist which is LinkedList.
//It has all the properties of a singly as well as doubly list.
//It can also be used to build queues
//LinkedList<T> list=new LinkedList<T>();