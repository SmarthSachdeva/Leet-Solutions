/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || k == 0) return head;

        ListNode curr = head , prev = head;
        ListNode temp ;
        while(k > 1){
            k-=1;
            curr = curr.next;
        }
        temp = curr;
        while(curr.next!=null){
            prev = prev.next;
            curr = curr.next;
        }

        int tempData = temp.val;
        temp.val = prev.val;
        prev.val = tempData;

        return head;

    }
}