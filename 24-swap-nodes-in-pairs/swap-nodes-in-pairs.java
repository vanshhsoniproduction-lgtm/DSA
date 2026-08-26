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
    public ListNode swapPairs(ListNode head) {
        ListNode answer = new ListNode(-1);
        answer.next = head;
        ListNode temp = head;
        ListNode prev = answer;
        
        while(temp != null && temp.next != null){
            ListNode swap = temp.next;
            ListNode next = temp.next.next;
            prev.next = swap;
            swap.next = temp;
            temp.next = next;
            prev = temp;
            temp = next;
            
        }
        return answer.next;
    }
}