import java.io.*;
import java.util.*;


//Important Methods - Insertion,Deletion,successor,predecessor
class Node{
	int data;
	Node left;
	Node right;
	Node parent;
	public Node(int data,Node left,Node right,Node parent){
		this.data=data;
		this.left=left;
		this.right=right;
		this.parent=parent;
	}
	public String toString(){
		return "Data = "+this.data;
	}
}
class Tree{
	private Node tree;
	private Node root;
	private int size;
	public Tree(){
		this.tree=null;
		this.root=null;
		this.size=0;
	}
	public int getSize(){
		return this.size;
	}
	public Node getRoot(){
		return this.root;
	}
	public void InOrder(Node node){
		if(node == null){
			return;
		}
		InOrder(node.left);
		System.out.print(node.data+" ");
		InOrder(node.right);
	}
	public void PreOrder(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data+" ");
		PreOrder(node.left);
		PreOrder(node.right);
	}
	public void PostOrder(Node node){
		if(node == null){
			return;
		}
		PostOrder(node.left);
		PostOrder(node.right);
		System.out.print(node.data+" ");
	}
	public Node search(int key){
		Node node = this.root;
		while(node!=null && node.data!=key){
			if(node.data > key)
				node=node.left;
			else node=node.right;
		}
		return node;
	}
	public Node minimum(Node node){
		while(node.left!=null){
			node=node.left;
		}
		return node;
	}
	public Node maximum(Node node){
		while(node.right!=null){
			node=node.right;
		}
		return node;
	}
	// Important
	public Node successor(int key){
		Node node = search(key);
		if(node == null)
			return null;
		if(node.right!=null)
			return minimum(node.right);
		else{
			Node parent = node.parent;
			while(parent!=null && parent.right == node){
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	//Important
	public Node predecessor(int key){
		Node node = search(key);
		if(node == null)
			return null;
		if(node.left!=null)
			return maximum(node.left);
		else{
			Node parent=node.parent;
			while(parent!=null && parent.left == node){
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	public void insert(Node node){
		size++;
		Node parent = null;
		Node x = this.root;
		while(x!=null){
			parent=x;
			if(node.data>x.data)
				x=x.right;
			else x=x.left;
		}
		node.parent = parent;
		if(parent==null){
			this.root = node;
		}else if(parent.data < node.data){
			parent.right=node;
		}else parent.left=node;
	}
	//This is only for redefining the parent relations
	public void transplant(Node u,Node v){
		if(u.parent==null)
			this.root = v;
		if(u == u.parent.left)
			u.parent.left=v;
		else u.parent.right=v;
		if(v!=null)
			v.parent = u.parent;
	}
	public void delete(int key){
		size--;
		Node node = search(key);
		if(node.left==null)
			transplant(node,node.right);
		else if(node.right == null)
			transplant(node,node.left);
		else{
			Node r=minimum(node.right);
			if(r.parent!=node){
				transplant(r,r.right);
				r.right = node.right;
				r.right.parent = r;
			}
			transplant(node,r);
			r.left=node.left;
			r.left.parent=r;
		}
	}
	public Node LCA(int u,int v,Node root){//O(h) where h is bounded by lg(n)
		if(root.data > u && root.data > v){
			root = root.left;
		}else if(root.data < u && root.data < v){
			root = root.right;
		}else{
			return root;
		}
		return LCA(u,v,root);
	}
}
public class BinaryTree{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		Tree tree = new Tree();
		int value;
		System.out.println("Options\n0.Exit\n1.Insert\n2.Delete\n3.InOrderWalk\n4.PreOrderWalk\n5.PostOrderWalk\n6.Minimum\n7.Maximum\n8.Search\n9.Successor\n10.Predecessor\n11.GetSize\n12.GetRoot\n13.FindLCA");
		while(true){
			System.out.print("Enter your option : ");
			int op=sc.nextInt();
			switch(op){
				case 0:System.out.println("Exiting......");
						return;
				case 1:System.out.print("Enter the value of node : ");
						value=sc.nextInt();
						Node node=new Node(value,null,null,null);
						tree.insert(node);
						break;
				case 2:System.out.print("Enter the value to be deleted : ");
						value=sc.nextInt();
						tree.delete(value);
						System.out.println("deleted");
						break;
				case 3:tree.InOrder(tree.getRoot());
						System.out.println();
						break;
				case 4:tree.PreOrder(tree.getRoot());
						System.out.println();
						break;
				case 5:tree.PostOrder(tree.getRoot());
						System.out.println();
						break;
				case 6:System.out.println("Minimum -> "+tree.minimum(tree.getRoot()).data);
						break;
				case 7:System.out.println("Maximum -> "+tree.maximum(tree.getRoot()).data);
						break;
				case 8:System.out.println("Enter the number to be searched");
						value=sc.nextInt();
						if(tree.search(value)!=null)
							System.out.println("The value is present");
						else System.out.println("The value is absent");
						break;
				case 9:value=sc.nextInt();
						System.out.println("Successor -> "+tree.successor(value).data);
						break;
				case 10:value=sc.nextInt();
						System.out.println("Predecessor -> "+tree.predecessor(value).data);
						break;
				case 11:System.out.println("No.of elements -> "+tree.getSize());
						break;
				case 12:System.out.println("Root -> "+tree.getRoot().data);
						break;
				case 13:System.out.println("Enter the nodes");
						int u=sc.nextInt();
						int v=sc.nextInt();
						System.out.println("The LCA is  :: "+tree.LCA(u,v,tree.getRoot()).toString());
				default:System.out.println("Enter a valid option");
			}
		}
	}
}