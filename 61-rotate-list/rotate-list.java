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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        // Find length
        int length = 0;
        ListNode t = head;

        while (t != null) {
            length++;
            t = t.next;
        }

        // Reduce unnecessary rotations
        k = k % length;
        while(k>0){
            ListNode temp = head;
            ListNode t1 = null;
            ListNode t2 = null;
            while(temp!=null){
                if(temp.next != null &&  temp.next.next == null){
                    t1 = temp;
                }
                if(temp.next == null){
                    t2 = temp;
                }
                temp = temp.next;
            }
            t2.next = head;
            t1.next = null;
            head = t2;

            k--;
        }
        return head;
    }
}