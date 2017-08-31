import java.util.*;
import java.lang.*;
import java.io.*;

public class MaxSubSequence {
    static int subsequences(String a,String b){
        int dp[][]=new int[a.length()+1][b.length()+1];
        int i,j;
        for(i=0;i<(a.length()+1);i++){
            dp[i][0]=0;
        }
        for(i=0;i<(b.length()+1);i++){
            dp[0][i]=0;
        }
        for(i=1;i<=a.length();i++){
            for(j=1;j<=b.length();j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else if(dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        //System.out.println("Length = "+dp[a.length()][b.length()]);
        return (dp[a.length()][b.length()] > 0)?1:0;
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		//sc.nextLine();
		for(int z=1;z<=t;z++){
		    String str1 = sc.next();
		    String str2 = sc.next();
		    System.out.println(subsequences(str1,str2));
		}
	}
}