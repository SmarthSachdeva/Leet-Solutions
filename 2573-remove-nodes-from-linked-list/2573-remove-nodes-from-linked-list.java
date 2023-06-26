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


 //BRUTE FORCE
// class Solution {
//     public ListNode removeNodes(ListNode head) {
//         ListNode dummy = new ListNode(0);
//         ListNode curr = dummy;
//         while(head != null){
//             ListNode temp = head;
//             int max = head.val;
//             while(temp!=null){
//                 max=Math.max(max,temp.val);
//                 if(max!=head.val) break;
//                 temp=temp.next;
//             }

//             if(max==head.val){
//                 ListNode temp1 = new ListNode(head.val);
//                 curr.next = temp1;
//                 curr = curr.next;

//             }
//             head=head.next;
            
//         }
//         curr.next=null;
//         return dummy.next  ;
//     }
// }



//Optimized 
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode reverse = rev(head);
        while(reverse!=null){

            if(s.isEmpty() || (!s.isEmpty() && reverse.val>=s.peek())){
                s.push(reverse.val);
            }
            

            reverse=reverse.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!s.isEmpty()){
            ListNode temp1 = new ListNode(s.pop());
            curr.next = temp1;
            curr = curr.next;

        }
        return dummy.next;

        
    }
    public ListNode rev(ListNode head){
        ListNode forward=null;
        ListNode perv=null;
        ListNode curr=head;
        while(curr!=null){
            forward=curr.next;
            curr.next=perv;
            perv=curr;
            curr=forward;
        }
        return perv;


    }
}