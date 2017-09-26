import java.util.*;
import java.lang.*;
import java.io.*;

public class LongestPalindromeV2 {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		for(int z=1;z<=t;z++){
		    String str = sc.nextLine();
		    int n=str.length();
		    int max = Integer.MIN_VALUE;
		    String result = "";
		    int i,j;
		    boolean table[][]=new boolean[n+1][n+1];
		    for(i=0;i<n;i++){
		        for(j=0;(i+j)<n && (i-j)>=0;j++){
		            if(str.charAt(i-j)==str.charAt(i+j)){
		                if(max<(2*j+1)){
		                    max = 2*j+1;
		                    result = str.substring(i-j,i+j+1);
		                }
		            }else break;
		        }
		        int k=0;
	            j=i+1;
	            for(k=0;(i-k)>=0 && (j+k)<n;k++){
	                if(str.charAt(i-k) == str.charAt(j+k)){
	                    if(max < (2*k+2)){
	                        max = 2*k+2;
	                        result = str.substring(i-k,j+k+1);
	                    }
	                }else break;
	            }
		    }
		    System.out.println(result);   
		}
	}
}