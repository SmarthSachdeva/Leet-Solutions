public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headB;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = headB;

        ListNode slow = headA , fast = headA;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            temp.next = null;
            return null;
        }

        slow = headA;

        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        temp.next = null;
        return slow;
    }
}