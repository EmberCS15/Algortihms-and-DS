/**
 * Definition for singly-linked list.*/
class ListNode {
    public int val;
    public ListNode next;
 	ListNode(int x) { val = x; next = null; }
 }

public class LinkedListInsertionSort {
	public ListNode detectCycle(ListNode a) {
	    HashMap<ListNode,Boolean> map = new HashMap<ListNode,Boolean>();
	    while(a!=null){
	        if(!map.containsKey(a)){
	            map.put(a,true);
	        }
	        else if(map.get(a) == true)
	            break;
	        a=a.next;
	    }
	    if(a==null)
	    	System.out.println("No cycle");
	    else System.out.println("Cycle Present");
	    //if a== null then no cycle else a is the start of the cycle
	    return a;
	}
	public ListNode insert(ListNode start, ListNode x) {
	    if (start == null) {
	        return x;
	    }
	    if (x.val < start.val) {
	        x.next = start;
	        start = x;
	        return start;
	    }
	    ListNode p = start;
	    while (p.next != null && p.next.val <= x.val) {
	        p = p.next;
	    }
	    x.next = p.next;
	    p.next = x;
	    
	    return start;
	}
	public static void main(String args[]){
		Scanner sc=new Scanner();
		ListNode start = null;
		int n=sc.nextInt();
		for(i=0;i<n;i++){
			int num = sc.nextOInt();
			if(start == null){
				start = insert(start , new ListNode(num));
			}
		}
	}
}

