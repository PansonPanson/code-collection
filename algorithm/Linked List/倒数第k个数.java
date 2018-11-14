/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        if (k <= 0 || head == null) {
            return null;
        }
        for (int i = 0; i < k - 1; i++){
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                return null;
            }
            
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
             return p2;
    }
}