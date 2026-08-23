/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode A = head;
        ListNode B = head;
        try{
            while(A!=null){
                                    A=A.next;
                    B=B.next.next;
                if(A==B){return true;}
                

                
            }
        }catch (Throwable t) {return false;}
    return false;
    }
}