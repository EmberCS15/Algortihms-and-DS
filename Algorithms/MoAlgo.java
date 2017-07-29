import java.util.*;
import java.io.*;


//Range Sum problem using Mo's Algorithm
public class MoAlgo{
	static int block;
	static class Query{
		int l;
		int r;
		public Query(int l,int r){
			this.l=l;
			this.r=r;
		}
	} 
	static void query(Query qr[],int ar[]){
		int currL = 0;
		int currR = 0;
		int currSum = 0;
		for(int i=0;i<qr.length;i++){
			int L=qr[i].l;
			int R=qr[i].r;
			//Only one of these loops will execute
			while(currL<L){
				currSum -= ar[currL];
				currL++;
			}
			while(currL > L){
				currSum += ar[currL-1];
				currL--;
			}
			//Only one of these loops will execute
			while(currR <= R){
				currSum += ar[currR];
				currR++;
			}
			while(currL > (R+1)){	
				currSum += ar[currR-1];
				currR--;
			}
			System.out.println("Query : ["+L+","+R+"] = "+currSum);
		}	
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[n];
		int i=0;
		for(i=0;i<n;i++){
			ar[i]=sc.nextInt();
		}
		int q=sc.nextInt();
		Query qr[]=new Query[q];
		for(i=0;i<q;i++){
			int l=sc.nextInt();
			int r=sc.nextInt();
			qr[i] = new Query(l,r);
		}
		block = (int)Math.sqrt(n);
		Arrays.sort(qr,new Comparator<Query>(){
			public int compare(Query q1,Query q2){
				if(q1.l/block != q2.l/block){
					return q1.l/block - q2.l/block;
				}
				return q1.r-q2.r;
			}
		});
		query(qr,ar);
	}
}
//Time Complexity is  -  O((m+n)*sqrt(n)) (See the explanation from geeks for geeks)