import java.io.*;
import java.util.*;

public class CircleChords {
    static long CalculateDP(long dp[],int n){
        if(n<0){
            return 0;
        }
        else if(n==1||n==0){
            return 1;
        }else if(n==2){
            return 2;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        long mod = (long)Math.pow(10,9)+7;
        for(int i=0;i<=n-1;i++){
            dp[n]+=((CalculateDP(dp,i)%mod)*(CalculateDP(dp,n-i-1)%mod))%mod;
            dp[n]%=mod;
        }
        return dp[n]%mod;
    }
    static long solve(int n) {
        long dp[]=new long[n+1];
        long mod = (long)Math.pow(10,9)+7;
        int i;
        dp[0]=1;
        for(i=0;i<=n-1;i++){
            dp[n]+=((CalculateDP(dp,i)%mod)*(CalculateDP(dp,n-i-1)%mod))%mod;
            dp[n]%=mod;
        }
        return dp[n]%mod;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i,j;
        System.out.println("The result :: "+solve(n));
        sc.close();
    }
}
/*

Think in terms of DP.
Can we relate answer for N with smaller answers.

If we draw a chord between any two points, can you observe current set of points getting broken into two smaller sets S_1 and S_2? Can a chord be drawn between two points where each point belong to different set?

If we draw a chord from a point in S_1 to a point in S_2, it will surely intersect the chord we’ve just drawn.

So, we can arrive at a recurrence that Ways(n) = sum[i = 0 to n-1] { Ways(i)*Ways(n-i-1) }.
Here we iterate over i, assuming that size of one of the sets is i and size of other set automatically is (n-i-1) since we’ve already used a pair of points and i pair of points in one set.
*/
