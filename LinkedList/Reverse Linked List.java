/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode pre=null;
        ListNode current=head;
        ListNode next=null;
        
        while(current!=null){
            
            next = current.next;
            current.next=pre;
            pre=current;
            current=next;
            
            head=pre;
        }
        return head;
    }
}
