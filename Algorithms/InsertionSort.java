import java.util.*;
import java.io.*;

public class InsertionSort{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		//pw.println("Enter the total size of the array");
		int n=sc.nextInt();
		//pw.println("Enter the elements of the array");
		int ar[]=new int[n];
		int i,j;
		for(i=0;i<n;i++){
			ar[i]=sc.nextInt();
		}
		for(i=1;i<ar.length;i++){//O(n)
			int key=ar[i];
			for(j=i-1;j>=0 && ar[j]>key;j--){//O(n)
				ar[j+1]=ar[j];
			}
			ar[j+1]=key;
		}
		pw.println("The sorted Array is :: ");
		for(int x:ar)
			pw.print(x+ " ");
		pw.close();
	}
}

/*If the array is considered to be zero indexed we start i from 1 through to the end. for each ar[i] we
trace back and try to find the correct position for this element.

We use the following check - 1. ar[j]>key then ar[j+1]=ar[j] else break;
*/
//Worst Case running time of O(n^2)
//Best Case : If the input array is already sorted O(n)