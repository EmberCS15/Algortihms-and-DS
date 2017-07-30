import java.io.*;
import java.util.*;

class TreeNode{
	int key,height;
	TreeNode left,right;
	public TreeNode(int key){
		this.key = key;
		this.height = 1;
		left = right = null;
	} 
}
class AVLTree{
	TreeNode root = null;
	public int height(TreeNode node){
		if(node == null){
			return 0;
		}
		return 1+Math.max(height(node.left),height(node.right));
	}
	public int getBalance(TreeNode node){
		if(node == null)
			return 0;
		int lh = height(node.left);
		int rh = height(node.right);
		return lh-rh;
	}
	public TreeNode rightRotate(TreeNode z){
		TreeNode y = z.left;
		TreeNode x = y.right;
		y.right = z;
		z.left = x;
		y.height = 1+Math.max(height(y.left),height(y.right));
		z.height = 1+Math.max(height(z.left),height(z.right));
		return y;
	}
	public TreeNode leftRotate(TreeNode z){
		TreeNode y = z.right;
		TreeNode x = y.left;
		y.left = z;
		z.right = x;
		y.height = 1+Math.max(height(y.left),height(y.right));
		z.height = 1+Math.max(height(z.left),height(z.right));
		return y;
	}
	public TreeNode insert(TreeNode node,int key){
		if(node == null){
			return new TreeNode(key);
		}
		if(key > node.key){
			node.right = insert(node.right,key);
		}else if(key < node.key){
			node.left = insert(node.left,key);
		}else{
			return node;
		}
		node.height = 1+Math.max(height(node.right),height(node.left));
		int balance = getBalance(node);
		if(balance > 1 && key < node.left.key){
			return rightRotate(node);
		}else if(balance > 1 && key > node.left.key){
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}else if(balance < -1 && key > node.right.key){
			return leftRotate(node);
		}else if(balance < -1 && key < node.right.key){
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}
	public void preOrder(TreeNode node){
		if(node == null)
			return;
		System.out.print(node.key+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
}
public class AVL{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		AVLTree tree = new AVLTree();
		tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
        System.out.println("preOrder traversal :: ");
        tree.preOrder(tree.root);
        sc.close();
	}
}