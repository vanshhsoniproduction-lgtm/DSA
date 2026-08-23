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
        ListNode A = headA;
        ListNode B = headB;
        int sizeA = 0;
        int sizeB = 0;
        while(A!=null){A = A.next; sizeA++;}
        while(B!=null){B = B.next; sizeB++;}
        int diff = Math.abs(sizeA-sizeB);
        A = headA;
        B = headB;
        if(sizeA>sizeB){
            for(int i=0; i<diff; i++){A=A.next;}
        }else if(sizeB>sizeA){
            for(int i=0; i<diff; i++){B=B.next;}
        }
        while(A!=null && B!=null){
            if(A == B){
                return A;
            }else{
                A=A.next;
                B=B.next;
            }
        }
    return null;
    }
}