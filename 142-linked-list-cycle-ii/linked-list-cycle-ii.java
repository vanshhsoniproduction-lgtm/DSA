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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode A = head;
        ListNode B = head;
        try{
            while(B != null && B.next != null){
                
                A=A.next;
                B=B.next.next;
                if(A==B){
                                ListNode X = head;

            while (X != A) {
                X = X.next;
                A = A.next;
            }
            return X;
                    
                }
                

                
            }
        }catch (Throwable t) {return null;}
    return null;
    }
}