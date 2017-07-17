import java.io.*;
import java.util.*;

public class BubbleSort{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int n=sc.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++){
			ar[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n-i-1;j++){
				if(ar[j]>ar[j+1]){
					int t=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=t;
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