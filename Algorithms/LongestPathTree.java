import java.util.*;
import java.io.*;

public class LongestPathTree {
    static int max_length = Integer.MIN_VALUE;
    static void DFSExplore(ArrayList<ArrayList<Integer>> graph,int node,ArrayList<Integer> A,int prev_len,boolean visited[]){
        visited[node] = true;
        int curr_length = 0;
        for(int x:graph.get(node)){
            if(!visited[x]){
                curr_length = prev_len+1;
                DFSExplore(graph,x,A,curr_length,visited);
            }
            max_length = Math.max(max_length,curr_length);
            curr_length = 0;
        }
    }
    static void longestPath(ArrayList<ArrayList<Integer>> graph,ArrayList<Integer> A){
        boolean visited[] = new boolean[A.size()];
        for(int i=0;i<A.size();i++){
            Arrays.fill(visited,false);
            DFSExplore(graph,i,A,0,visited);
        }
    }
    static int solve(ArrayList<Integer> A) {
        if(A.size() == 1)
            return 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int i=0;
        for(i=0;i<A.size();i++)
            graph.add(new ArrayList<Integer>());
        for(i=1;i<A.size();i++){
            graph.get(A.get(i)).add(i);
            graph.get(i).add(A.get(i));
        }
        longestPath(graph,A);
        return max_length;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            nodes.add(sc.nextInt());
        }
        System.out.println("The longest Path is :: "+solve(nodes));
        sc.close();
    }
}
