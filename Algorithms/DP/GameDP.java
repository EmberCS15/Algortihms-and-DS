import java.util.*;
import java.io.*;
import java.math.*;

//Given two players p1 and p2 and an array of size n<=2000 . If p1 is to make the first move and any player
//can only remove numbers from either end of the array then find the maximum score of p1 if both players play
//optimally.
public class GameDP{
	static class InputReader {
		public BufferedReader reader;
			public StringTokenizer tokenizer;
 
			public InputReader() {
				reader = new BufferedReader(new InputStreamReader(System.in));
				tokenizer = null;
			}
 
			public String next() {
				while (tokenizer == null || !tokenizer.hasMoreTokens()) {
					try {
						tokenizer = new StringTokenizer(reader.readLine());
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
				return tokenizer.nextToken();
			}
 
			public int nextInt() {
				return Integer.parseInt(next());
			}
 
			public long nextLong() {
				return Long.parseLong(next());
			}
 
			public double nextDouble() {
				return Double.parseDouble(next());
			}
 
			public String nextLine() {
				String s = null;
				try {
					s = reader.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				return s;
			}
 
			public String nextParagraph() {
				String line = null;
				String ans = "";
				try {
					while ((line = reader.readLine()) != null) {
						ans += line;
					}
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				return ans;
			}
		}
 
	static void printArray(int ar[]){
		for(int x:ar)
			System.out.print(x+" ");
	}
	static void printMatrix(Data ar[][],int n){
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				System.out.print("("+ar[i][j].p1+","+ar[i][j].p2+")");
			}
			System.out.println();
		}
	}
	static long gcd(long a,long b){
		if(b==0)
			return a;
		return gcd(b,a%b);
	}
	static class Data{
		int p1;
		int p2;
		public Data(int p1,int p2){
			this.p1=p1;
			this.p2=p2;
		}
	}
	static void MakeDp(Data dp[][],int ar[],int l,int r,int p,int n){
		if(l==r){
			if(p==1){
				dp[n-1][l]=new Data(ar[l],0);
			}else if(p==2){
				dp[n-1][l]=new Data(0,ar[l]);
			}
			return;
		}
		if(n==0){
			return;
		}
		if(l>r){
			return;
		}
		if(p==1){
			MakeDp(dp,ar,l,r-1,2,n-1);
			MakeDp(dp,ar,l+1,r,2,n-1);
			Data data1 = dp[n-2][r-1];
			Data data2 = dp[n-2][r];
			if(data1.p2<data2.p2){
				dp[n-1][r]=new Data(data1.p1+ar[r],data1.p2);
			}else if(data1.p2>data2.p2){
				dp[n-1][r]=new Data(data2.p1+ar[l],data2.p2);
			}else{
				dp[n-1][r]=new Data(Math.max(data2.p1+ar[l],data1.p1+ar[r]),data2.p2);
			}
		}
		else if(p==2){
			MakeDp(dp,ar,l,r-1,1,n-1);
			MakeDp(dp,ar,l+1,r,1,n-1);
			Data data1 = dp[n-2][r-1];
			Data data2 = dp[n-2][r];
			if(data1.p1<data2.p1){
				dp[n-1][r]=new Data(data1.p1,data1.p2+ar[r]);
			}else if(data1.p1>data2.p1){
				dp[n-1][r]=new Data(data2.p1,data2.p2+ar[l]);
			}else{
				dp[n-1][r]=new Data(data2.p1,Math.max(data2.p2+ar[l],data2.p2+ar[r]));
			}
		}
	}
	public static void main(String args[]){
		InputReader sc=new InputReader();
		PrintWriter pw=new PrintWriter(System.out);
		int i,j;
		int n=sc.nextInt();
		int ar[]=new int[n];
		for(i=0;i<n;i++){
			ar[i]=sc.nextInt();
		}
		Data dp[][]=new Data[n+1][n+1];
		MakeDp(dp,ar,0,n-1,1,n);
		printMatrix(dp,n);
		pw.println("Maximum Sum for player 1 :: "+(dp[n-1][n-1]).p1);
		pw.close();
	}
} 