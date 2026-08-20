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
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode x = head;
        while(x.next != null){
            size ++;
            x = x.next;
        }
        int mid = size/2;
        x = head;
        if(size%2==0){
            for(int i=0; i<mid; i++){
            x = x.next;
        }
        return x;
        }
        else{
            for(int i=0; i<=mid; i++){
            x = x.next;
        }
        return x;

        }
    }
}