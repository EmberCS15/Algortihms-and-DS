//It often serves as a substitute for segment tree in case of immutable data.
/*Sparse table can be applied if and only if:

    1.Arr is immutable (i.e. queries do not change it);
    2.Function F is associative: F(a, b, c) = F(F(a, b), c) = F(a, F(b, c)).

Sparse table is easy to code and it is quite fast. Still the problems with completely immutable data are somewhat rare. I find sparse table one of my personal favourite approaches.
*/
//Sparse Table Data Structure
//Range Minimum Query using the Sparse Tables
import java.util.*;
import java.io.*;

public class SparseTable{
	static void printArray(int table[][],int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
	}
	static int CalculateMin(int table[][],int l,int r,int k){
		int answer = Integer.MAX_VALUE;
		int ltemp = l;
		int i;
		for(i=k;i>=0;i--){
			if(ltemp+(int)Math.pow(2,i)-1<=r){
				answer = Math.min(answer,table[ltemp][i]);
				ltemp+=(int)Math.pow(2,i);
			}
		}
		return answer;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[n];
		int i,j;
		int table[][]=new int[n][n];
		for(i=0;i<n;i++){
			ar[i]=sc.nextInt();
			table[i][0]=ar[i];
		}
		int count = 0;
		int temp=n;
		while(temp!=0){//O(lgn)
			temp>>=1;
			count++;
		}
		for(j=1;j<count;j++){//O(count*N) = O(N*count) and count is a small number
			for(i=0;i<=n-(int)Math.pow(2,j);i++){
				table[i][j]=Math.min(table[i][j-1],table[i+(int)Math.pow(2,j-1)][j-1]);
			}
		}
		//printArray(table,n);
		System.out.println("Enter the number of Queries :: ");
		int m=sc.nextInt();
		for(i=0;i<m;i++){
			int l=sc.nextInt();
			int r=sc.nextInt();
			int num = r-l+1;
			int k=0;
			while(num!=0){
				num = num>>1;
				k++;
			}
			System.out.println("The value is :: "+CalculateMin(table,l,r,k));
		}
	}
}
