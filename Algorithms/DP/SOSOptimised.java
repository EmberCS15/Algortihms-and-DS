import java.io.*;
import java.util.*;

//I will be addressing the following problem: Given a fixed array A of 2N integers, 
//we need to calculate ∀ x function F(x) = Sum of all A[i] such that x&i = i, i.e., i is a subset of x.
public class SOSOptimised{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[1<<n];
		int i;
		for(i=0;i<(1<<n);i++){
			ar[i]=sc.nextInt();
		}
		int dp[][]=new int[1<<n][n+1];
		int F[]=new int[1<<n];
		int mask;
		for(mask=0;mask<(1<<n);mask++){
			dp[mask][0]=ar[mask];
			for(i=1;i<=n;i++){
				if((mask&(1<<(i-1))) != 0){
					dp[mask][i] = dp[mask][i-1]+dp[mask^(1<<(i-1))][i-1];
				}
				else{
					dp[mask][i]=dp[mask][i-1];
				}
			}
			F[mask] = dp[mask][n];
		}
		System.out.println("The value of the sums is :: ");
		for(i=0;i<(1<<n);i++){
			System.out.println("Index = "+i+" Sum = "+F[i]);
		}
	}
}