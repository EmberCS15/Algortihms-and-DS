import java.io.*;
import java.util.*;

public class AreaRect {
    static class Data{
        int data;
        int pos;
        public Data(int data,int pos){
            this.data = data;
            this.pos = pos;
        }
    }
    static void SortPos(Integer pos[],int n){
        Arrays.sort(pos,new Comparator<Integer>(){
            @Override
            public int compare(Integer d1,Integer d2){
                return d2-d1;
            }
        });
    }
    static int solve(ArrayList<ArrayList<Integer>> A) {
        int ar[][]=new int[A.size()+1][A.get(0).size()];
        int i,j;
        for(i=0;i<A.get(0).size();i++){
            ar[0][i] = A.get(0).get(i);
        }
        for(i=0;i<A.get(0).size();i++){
            for(j=1;j<A.size();j++){
                ar[j][i] = (A.get(j).get(i) != 0)?ar[j-1][i]+1:0;
            }
        }
        int result = Integer.MIN_VALUE;
        Integer position[]=new Integer[A.get(0).size()];
        for(i=0;i<A.size();i++){
            for(j=0;j<A.get(0).size();j++){
                position[j]=ar[i][j];
            }
            SortPos(position,position.length);
            int val = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(j=0;j<A.get(0).size();j++){
                val = Math.min(val,position[j]);
                max = Math.max(max,(j+1)*val);
            }
            result = Math.max(result,max);
        }
        return result;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int i,j;
        ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
        for(i=0;i<r;i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(j=0;j<c;j++){
                int num = sc.nextInt();
                list.add(num);
            }
            alist.add(list);
        }
        System.out.println("The result :: "+solve(alist));
        sc.close();
    }
}
