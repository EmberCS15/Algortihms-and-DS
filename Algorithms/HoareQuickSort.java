import java.io.*;
import java.util.*;

public class HoareQuickSort{
	static void swap(int ar[],int i,int j){
		int t=ar[i];
		ar[i]=ar[j];
		ar[j]=t;
	}
	static int HoarePartition(int ar[],int l,int r){
		int pivot = ar[r];
		int i=l;
		int j=r-1;
		while(i<j){
			while(i<j && ar[i]<pivot)
				i++;
			while(i<j && ar[j]>=pivot)
				j--;
			swap(ar,i,j);
		}
		swap(ar,i,r);
		return i;
	}
	static void quickSort(int ar[],int l,int r){
		if(l>r)
			return;
		int q=HoarePartition(ar,l,r);
		quickSort(ar,l,q-1);
		quickSort(ar,q+1,r); 
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int n=sc.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++){
			ar[i]=sc.nextInt();
		}
		quickSort(ar,0,ar.length-1);
		pw.println("The sorted array is :: ");
		for(int x:ar)
			pw.print(x+" ");
		pw.close();
	}
}

/*T(n)=2*T(n/2)+O(n)
By using the master method = Worst case:If the array is already sorted = T(n) = O(n^2)
Best case = T(n)=O(nlgn)
*/
