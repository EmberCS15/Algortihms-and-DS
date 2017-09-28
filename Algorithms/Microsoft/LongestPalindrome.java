import java.util.*;
import java.lang.*;
import java.io.*;

public class LongestPalindrome {
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
		        table[i][i]=true;
		        if(max<1){
		            result = ""+str.charAt(i);
		            max = 1;
		        }
		    }
		    for(j=1;j<n;j++){
		        if(str.charAt(j-1) == str.charAt(j)){
		            table[j-1][j]=true;
		            if(max<2){
		                max=2;
		                result = str.substring(j-1,j+1);
		            }
		        }
		    }
		    for(int len=3;len<=n;len++){
		        for(i=0;i<n-len+1;i++){
		            j=i+len-1;
		            if(table[i+1][j-1] && str.charAt(i) == str.charAt(j)){
		                table[i][j]=true;
		                if(max<(j-i+1)){
		                    max = j-i+1;
		                    result = str.substring(i,j+1);
		                }
		            }
		        }
		    }
		    System.out.println(result);   
		}
	}
}