package leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public static void print(ListNode head) {
    	System.out.print("[");
    	for (ListNode p = head; p != null; p = p.next) {
    	    System.out.printf("%d,", p.val);
        }
    	System.out.println("]");
    }
}
