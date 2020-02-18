/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        
        
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        
        while(head!=null && fastPointer.next!=null && fastPointer!=null){
            
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            
        }
        return slowPointer;
    }
}
