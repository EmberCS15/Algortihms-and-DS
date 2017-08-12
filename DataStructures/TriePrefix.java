import java.util.*;
import java.io.*;

public class TriePrefix {
	static class TrieNode{
		boolean isLeaf;
		TrieNode children[];
		int totalChildren;
		public TrieNode(){
			children = new TrieNode[26];
			Arrays.fill(children,null);
			isLeaf = false;
			totalChildren = 0;
		}
	}
	static class Trie{
		TrieNode root;
		public Trie(TrieNode root){
			this.root = root;
		}
		public void insert(TrieNode node,String str){
			TrieNode pcrawl = node;
			int i=0;
			while(i<str.length()){
				pcrawl.totalChildren+=1;
				if(pcrawl.children[str.charAt(i)-'a'] == null){
					pcrawl.children[str.charAt(i)-'a'] = new TrieNode();
				}
				pcrawl = pcrawl.children[str.charAt(i)-'a'];
				i++;
			}
			pcrawl.isLeaf = true;
		}
		public String getPrefix(TrieNode root,String word){
			TrieNode pcrawl = root;
			String result="";
			int i=0;
			while(!pcrawl.isLeaf && pcrawl.totalChildren != 1){
				pcrawl = pcrawl.children[word.charAt(i)-'a'];
				result+=word.charAt(i);
				i++;
			}
			return result;
		}
	}
	static ArrayList<String> prefix(ArrayList<String> a) {
		TrieNode root = new TrieNode();
		Trie trie = new Trie(root);
		for(String str : a)
			trie.insert(root,str);
		ArrayList<String> result = new ArrayList<String>();
		for(String str:a)
			result.add(trie.getPrefix(root,str));
		return result;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		ArrayList<String> array = new ArrayList<String>();
		for(int i=0;i<n;i++)
			array.add(sc.nextLine());
		ArrayList<String> re = prefix(array);
		for(String str:re)
			System.out.println("Prefix : "+str);
	}
}
