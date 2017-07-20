import java.util.*;
import java.io.*;

public class KMP{
	static void computePrefixTree(int prefixTree[],String P){
		int k=-1;
		for(int i=1;i<P.length();i++){
			while(k>-1 && P.charAt(i)!=P.charAt(k+1)){
				k=prefixTree[k];
			}
			if(P.charAt(i) == P.charAt(k+1))
				k++;
			prefixTree[i]=k;
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String T=sc.nextLine();
		String P=sc.nextLine();
		int i;
		int prefixTree[]=new int[P.length()];
		Arrays.fill(prefixTree,-1);
		computePrefixTree(prefixTree,P);
		int q=-1;
		for(i=0;i<T.length();i++){
			while(q>-1 && T.charAt(i)!=P.charAt(q+1)){
				q=prefixTree[q];
			}
			if(T.charAt(i) == P.charAt(q+1))
				q++;
			if((q+1) == P.length()){
				System.out.println("Pattern Occurs at "+(i-q));
				q=prefixTree[q];
			}
		}
	}
}

//Using Amortized Analysis the running time of KMP is O(n)