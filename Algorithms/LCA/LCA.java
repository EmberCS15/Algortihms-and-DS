import java.util.*;
import java.io.*;

public class LCA{
	static class Node{
		int data;
		Node left;
		Node right;
		Node parent;
		public Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
			this.parent=null;
		}
		public String toString(){
			return "Data = "+this.data;
		}
	}
	static boolean findPath(Node root,LinkedList<Node> path,int n){
		if(root == null)
			return false;
		if(root.data == n){
			path.addLast(root);
			return true;
		}
		path.addLast(root);
		while((root.left!=null && findPath(root.left,path,n)) || (root.right!=null && findPath(root.right,path,n))){
			return true;
		}
		path.pollLast();
		return false;
	}
	static Node findLCA(Node root,int u,int v){
		LinkedList<Node> p1=new LinkedList<Node>();
		LinkedList<Node> p2=new LinkedList<Node>();
		if(!findPath(root,p1,u) || !findPath(root,p2,v)){
			return new Node(-1);
		}
		//System.out.println(p1.size()+""+p2.size());
		for(int i=0;i<p1.size() && i<p2.size();i++){
			if (p1.get(i).data != p2.get(i).data) {
				return p1.get(i-1);
			}
		}
		return new Node(-1);
	}
	static Node findParentPointerLCA(Node root,int u,int v){//O(n) as this method does a simple tree traversal from top to bottom
		if(root == null)
			return null;
		if(root.data == u || root.data == v){
			return root;
		}
		Node left = findParentPointerLCA(root.left,u,v);
		Node right = findParentPointerLCA(root.right,u,v);
		if(left!=null && right!=null){
			return root;
		}
		return (left!=null)?left:right;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.right = new Node(3);
		root.left.right.right = new Node(5);
		root.left.right.left = new Node(7);
		root.left.left = new Node(10);
		int u,v;
		System.out.println("Options\n1.FindLCA using 2 traversal technique \n2.Find LCA using parent pointer technique\n3.Exit :: ");
		while(true){
			System.out.println("Enter your option :: ");
			int choice = sc.nextInt();
			switch(choice){
				case 1:System.out.println("Enter the nodes u and v");
						u=sc.nextInt();
						v=sc.nextInt();
						System.out.println("The LCA is :: "+findLCA(root,u,v));
						break;
				case 2:System.out.println("Enter the nodes u and v");
						u=sc.nextInt();
						v=sc.nextInt();
						System.out.println("The LCA is :: "+findParentPointerLCA(root,u,v));
						break;
				case 3:System.out.println("Exiting ..... ");
						sc.close();
						return;
				default:System.out.println("Please enter a valid option");
			}
		}
	}
}
