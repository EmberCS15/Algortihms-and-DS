import java.util.*;
import java.io.*;
public class ChefAndFibonacci{
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
	static void printMatrix(int ar[][],int n){
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
	}
	static int mod = 1000000007;
	static int countArrays(int dp[][][],int ar[],int d1,int d2,int index,int size){
		if(index >= size)
			return 1;
		if(dp[index][d1][d2]!=0)
			return dp[index][d1][d2];
		int total = 0,n=0;
		for(int i=0;i<=Math.min(d1,d2);i++){
			if(index+2 >= size && d1!=0 && d2!= 0){
				n=i;
				size++;
			}else if(index+2 < size){
				n=ar[index+2]+i;
			}
			total = total%mod + countArrays(dp,ar,d2-i,n,index+1,size)%mod;
		}
		dp[index][d1][d2] = total%mod;
		return dp[index][d1][d2];
	}
	public static void main(String args[]){
		InputReader sc=new InputReader();
		PrintWriter pw=new PrintWriter(System.out);
		int t=sc.nextInt();
		for(int z=1;z<=t;z++){
			int n=sc.nextInt();
			int i;
			int ar[]=new int[1000];
			for(i=0;i<n;i++){
				ar[i]=sc.nextInt();
			}
			int dp[][][]=new int[100][200][200];
			int n1 = ar[0],n2 = ar[1],n3;
			/*if(ar.length >= 3)
				n3 = ar[2];
			else n3 = 0;*/
			pw.println(countArrays(dp,ar,n1,n2,0,n));
		}
		pw.close();
	}
}  