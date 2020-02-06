/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode fake = new ListNode(0);
        ListNode p = fake;
        
        ListNode p1= l1;
        ListNode p2 = l2;
        
        int carry = 0;
        
        while(p!=null && p2 !=null){
            
            int sum = carry;
            
            if(p1!=null){
                sum += p1.val;
                p1=p1.next;
            }
            
            if(p2!=null){
                sum += p2.val;
                p2=p2.next;
            }
            
            if(sum>9){
                carry=1;
                sum =sum-10;
            }else{
                carry =0;
            }
            
            ListNode newNode = new ListNode(sum);
            p.next = newNode;
            p = p.next;
        }
        
        if(carry>0){
            
            ListNode p3 = new ListNode(carry);
            p.next = p3;
            p = p.next;
        }
        return fake.next;
    }
}
