import java.io.*;
import java.util.*;

public class MergeSort{
	static void Merge(int ar[],int l,int mid,int r){
		System.out.println(l+" "+mid+" "+r);
		int L[]=new int[mid-l+2];
		int R[]=new int[r-mid];
		int i;
		int litr=0;
		int ritr=0;
		for(i=l;i<=mid;i++){
			L[litr]=ar[i];
			litr++;
		}
		for(i=mid+1;i<=r;i++){
			R[ritr]=ar[i];
			ritr++;
		}
		litr--;ritr--;
		for(i=r;i>=l;i--){
			if(litr<0 || ritr<0)
				break;
			if(L[litr]>R[ritr]){
				ar[i]=L[litr];
				litr--;
			}else{
				ar[i]=R[ritr];
				ritr--;
			}
		}
		while(litr>=0){
			ar[i--]=L[litr];
			litr--;
		}
		while(ritr>=0){
			ar[i--]=R[ritr];
			ritr--;
		}
	}
	static void MergeSort(int ar[],int l,int r){
		if(l>=r){
			return;
		}
		int mid=(l+r)/2;
		MergeSort(ar,l,mid);
		MergeSort(ar,mid+1,r);
		Merge(ar,l,mid,r);
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int n=sc.nextInt();
		int ar[]=new int[n];
		int i;
		for(i=0;i<n;i++){
			ar[i]=sc.nextInt();
		}
		MergeSort(ar,0,ar.length-1);
		pw.println("The Sorted Array is :: ");
		for(int x:ar)
			pw.print(x+" ");
		pw.close();
	}
}

/*Calculation of Time Complexity : 
T(n)=2*T(n/2)+O(n)
Using Master Method - T(n)=aT(n/b)+f(n)
f(n)=n;
logb(a)=log2(2)=1 So , n^1=n
So f(n)=n^(lgb(a)).
By Master method - T(n)=n^(lgb(a))lg(n)=nlg(n)
*/

/*In merge sort - 1)We use divide and Conquer
				2) We divide the array into two parts each time and then merge them by seeing which element
				should be placed.*/