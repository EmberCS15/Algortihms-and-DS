import java.io.*;
import java.util.*;

public class SOSFast{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[1<<n];
		int F[]=new int[1<<n];
		int i,mask;
		for(i=0;i<(1<<n);i++){
			ar[i]=sc.nextInt();
			F[i]=ar[i];
		}
		for(i=0;i<n;i++){
			for(mask = 0;mask<(1<<n);mask++){
				if((mask & (1<<i)) != 0){
					F[mask] = F[mask]+F[mask^(1<<i)];
				}
			}
		}
		System.out.println("The value of the sums is :: ");
		for(i=0;i<(1<<n);i++){
			System.out.println("Index = "+i+" Sum = "+F[i]);
		}
	}
}