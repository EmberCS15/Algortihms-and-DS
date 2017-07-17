import java.io.*;
import java.util.*;

public class SelectionSort{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int n=sc.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++){
			ar[i]=sc.nextInt();
		}
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				if(ar[i]>ar[j]){
					int t=ar[i];
					ar[i]=ar[j];
					ar[j]=t;
				}
			}
		}
		pw.println("The sorted array is :: ");
		for(int x:ar)
			pw.print(x+" ");
		pw.close();
	}
}

/*Time Complexity = O(n^2)*/