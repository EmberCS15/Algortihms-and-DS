import java.util.*;
import java.io.*;


/*I will be addressing the following problem: Given a fixed array A of 2N integers, we need to calculate ∀ x function F(x) = Sum of all A[i] such that x&i = i, i.e., i is a subset of x.*/

public class SOS{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[(int)Math.pow(2,n)];
		int F[]=new int[1<<n];
		int i,j;
		int len = (int)Math.pow(2,n);
		for(i=0;i<(1<<n);i++)
			ar[i]=sc.nextInt();
		for(i=0;i<len;i++){
			//i=0 is a subset of all x>0
			F[i]=ar[0];
			//j=(j-1)&i gets us all the subsets of j
			for(j=i;j>0;j=(j-1)&i){
				F[i]+=ar[j];
			}
		}
		System.out.println("The value of the sums is :: ");
		for(i=0;i<(1<<n);i++){
			System.out.println("Index = "+i+" Sum = "+F[i]);
		}
	}	
}

/*Time complexity - outer loop runs for O(nCk) times as the total number of elements with k set bits is 
equal total number of ways of arranging k 1s in n spaces which nPk/k! = nCk. 
Suppose i consists of k set bits then the total number of subsets of i are equal to O(2^k). This is becuase
in each of the k posittions (position of set bits) we can have 0 or 1 while unset bits will remain unchanged.
Therefore the total time complexity is = O(Summation over k(nCk*2^k)) = O(3^k) */  