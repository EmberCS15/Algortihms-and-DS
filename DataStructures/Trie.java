import java.util.*;
import java.io.*;


//Tries in java
class TrieNode{
	TrieNode children[];
	boolean leaf;
	public TrieNode(){
		children = new TrieNode[26];
		for(int i=0;i<26;i++)
			children[i]=null;
		leaf = false;
	}
}
public class Trie{
	static void insert(String word,TrieNode trie_node){
		int i=0;
		for(i=0;i<word.length();i++){
			int index = word.charAt(i)-'a';
			if(trie_node.children[index] == null)
				trie_node.children[index] = new TrieNode(); 
			trie_node = trie_node.children[index];
		}
		trie_node.leaf = true;
	}
	static boolean search(String word,TrieNode trie_node){
		for(int i=0;i<word.length();i++){
			if(trie_node.children[word.charAt(i)-'a'] == null)
				return false;
			trie_node = trie_node.children[word.charAt(i)-'a'];
		}
		return true;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String words[]=new String[n];
		int i;
		for(i=0;i<n;i++){
			words[i]=sc.nextLine();
		}
		TrieNode trie_root = new TrieNode();
		for(i=0;i<n;i++){
			insert(words[i],trie_root);
		}
		System.out.println("Enter the number of terms to be searched :: ");
		int m=sc.nextInt();
		sc.nextLine();
		for(i=0;i<m;i++){
			String searchWord = sc.nextLine();
			if(search(searchWord,trie_root)){
				System.out.println("The node is present");
			}else{
				System.out.println("The node is absent");
			}
		}
		sc.close();
	}
}

//insert and search operations cost at most O(length of the longest key/word)
//The memory requirement is O(longes_key_length * 26 * n)