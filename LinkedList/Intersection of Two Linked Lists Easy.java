/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        HashMap<ListNode,Integer> hash = new HashMap<ListNode,Integer>();
        
        while(headA!=null){
            
            hash.put(headA,1);
            headA = headA.next;
        }
        
        while(headB!=null){
            
            if(hash.containsKey(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
