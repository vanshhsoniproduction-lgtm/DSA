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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode front = head;
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i < k; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        for(int i = 1; i < k; i++){
            front = front.next;
        }
        int temp = front.val;
        front.val = slow.val;
        slow.val = temp;
        return head;
    }
}