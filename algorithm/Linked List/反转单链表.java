/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode headNode = null;
        ListNode previousNode = null;
        ListNode currentNode = head;
        
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            
        }
        return headNode;
    }
}