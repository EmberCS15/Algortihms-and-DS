/*
1.Isolating the last set bit
x&(-x) isolates the last set bit
let x= a1b where a is a combination of 1s and 0s and b is only of 0s
(-x)=a'1b 
So x&(-x) = 0000...1000...0000 isolates the last set bit.
2.BIT[] array.For any element i - 
	BIT[x] = a[x] , if x is odd
		   = a[1]+....+a[x],if x is a power of 2
		   = Sum of all number from i-(1<<r)+1 to i (both inclusive) , Otherwise
3.When to use Binary Indexed Tree?

Before going for Binary Indexed tree to perform operations over range, one must confirm that the operation or the function is:

Associative. i.e f(f(a,b),c)=f(a,f(b,c))

this is true even for seg-tree

Has an inverse. eg:

    Addition has inverse subtraction (this example we have discussed)
    Multiplication has inverse division
    gcd()

    has no inverse, so we can’t use BIT to calculate range gcd’s
    Sum of matrices has inverse
    Product of matrices would have inverse if it is given that matrices are degenerate i.e. determinant of any matrix is not equal to 0

Space Complexity: O(N)
for declaring another array of size N

Time Complexity: O(logN)

for each operation(update and query as well)
*/

//This question carries the sum computation in a range
import java.io.*;
import java.util.*;

public class FenwickTree{
	static int BIT[];
	static void update(int x,int val,int n){
		for(;x<=n;x+=x&(-x))
			BIT[x]+=val;
	}
	//Query in interval [1,k]
	static int query(int x){	
		int sum=0;
		for(;x>0;x-=x&(-x))
			sum+=BIT[x];
		return sum;
	}
	static int queryRange(int l,int r){
		if(l>r){
			System.out.println("Please enter valid interval :: ");
			return Integer.MIN_VALUE;
		}
		int s1=0,s2=0;
		for(;l>0;l-=l&(-l))
			s1+=BIT[l];
		for(;r>0;r-=r&(-r))
			s2+=BIT[r];
		return s2-s1;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[n+1];
		BIT = new int[2*n];
		int i;
		for(i=1;i<n+1;i++){
			ar[i]=sc.nextInt();
			update(i,ar[i],n);
		}
		System.out.println("Enter the number of queries");
		int m=sc.nextInt();
		System.out.println("Options\n1.Query value in a range[1,k]\n2.Update an index\n3.Query an index [l,r]");
		for(i=0;i<m;i++){
			int c=sc.nextInt();
			switch(c){
				case 1:int l=sc.nextInt();
						System.out.println("The value of sum of all elements in this interval = "+query(l));
						break;
				case 2:int indx=sc.nextInt();
						int key=sc.nextInt();
						ar[indx]+=key;
						update(indx,key,n);
						System.out.println("Updated..");
						break;
				case 3:int lf=sc.nextInt();
						int rt=sc.nextInt();
						System.out.println("The sum of all values in this range = "+queryRange(lf-1,rt));
						break;
				default:System.out.println("Please enter valid option");
			}
		}
	}
}