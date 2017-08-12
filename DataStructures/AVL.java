import java.io.*;
import java.util.*;

class TreeNode{
	int key,height;
	TreeNode left,right;
	public TreeNode(int key){
		this.key = key;
		this.height = 1;
		this.left = this.right = null;
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

//Theory
/*
AVL tree is a self-balancing Binary Search Tree (BST) where the difference between heights of left 
and right subtrees cannot be more than one for all nodes.
Steps to follow for insertion
Let the newly inserted node be w
1) Perform standard BST insert for w.
2) Starting from w, travel up and find the first unbalanced node. Let z be the first unbalanced node, y be the child of z that comes on the path from w to z and x be the grandchild of z that comes on the path from w to z.
3) Re-balance the tree by performing appropriate rotations on the subtree rooted with z. There can be 4 possible cases that needs to be handled as x, y and z can be arranged in 4 ways. Following are the possible 4 arrangements:
a) y is left child of z and x is left child of y (Left Left Case)
b) y is left child of z and x is right child of y (Left Right Case)
c) y is right child of z and x is right child of y (Right Right Case)
d) y is right child of z and x is left child of y (Right Left Case)

Case a - rightRotate the node
Case b - leftRotate the child node then rightRotate the node
Case c - leftRotate the node
Case d - rightRotate the childNode and then leftRotate the node
*/