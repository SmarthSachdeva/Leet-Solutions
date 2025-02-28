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
    public int size(ListNode head){
        ListNode t = head;
        int cnt = 0;

        while(t != null) {
            t = t.next;
            cnt++;
        }
        return cnt;
    }
    public int getDecimalValue(ListNode head) {
        int size = size(head);
        int ans = 0;
        while(head != null){
            size--;

            if(head.val != 0){
                ans += Math.pow(2 , size);
            }

            head = head.next;
        }

        return ans;
    }
}