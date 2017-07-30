import java.io.*;
import java.util.*;



public class Maxor{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[n];
		int max=Integer.MIN_VALUE;
		int flag = 0;
		int i,j,mask;
		for(i=0;i<n;i++){
			ar[i]=sc.nextInt();
			max=Math.max(max,ar[i]);
			if(ar[i]==0)
				flag=1;	
		}
		int F[]=new int[max+1];
		for(i=0;i<n;i++){
			F[ar[i]]=1;
		}
		for(i=0;i<32;i++){
			for(mask=0;mask<max+1;mask++){
				if((mask&(1<<i))!=0){
					F[mask]+=F[mask^(1<<i)];
				}		
			}
		}
		int total = 0;
		/*for(int x:F)
			System.out.print(x+" ");*/
		for(i=0;i<n;i++){
			total += F[ar[i]]-1;
		}
		System.out.println(total);
	}
}