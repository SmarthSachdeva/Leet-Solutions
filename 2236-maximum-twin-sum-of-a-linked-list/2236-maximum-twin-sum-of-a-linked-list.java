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

    public int pairSum(ListNode head) {
        int maxTwinSum = 0;
        ListNode mid = getMid(head);
        mid = reverseSecondHalf(mid);

        ListNode left = head;
        ListNode right = mid;

        while (right != null) {
            maxTwinSum = Math.max(left.val + right.val, maxTwinSum);
            left = left.next;
            right = right.next;
        }

        return maxTwinSum;
    }

    private static ListNode reverseSecondHalf(ListNode head) {
        ListNode next, prev = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}