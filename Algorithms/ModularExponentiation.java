import java.io.*;
import java.util.*;

public class ModularExponentiation{
	static int modularExp(int n,int pow,int mod){
		int res=1;
		while(pow>0){
			if(pow%2!=0){
				res = (res *n)%mod;
			}
			pow=pow>>1;
			n=(n*n)%mod;
		}
		return res;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int pow=sc.nextInt();
		int mod = sc.nextInt();
		System.out.println("The modular exponentiation is :: "+modularExp(n,pow,mod));
		sc.close();
	}
}