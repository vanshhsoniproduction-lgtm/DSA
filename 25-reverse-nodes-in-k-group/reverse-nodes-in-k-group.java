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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode answer = new ListNode(-1);
        ListNode submit = answer;
        ArrayList<Integer> arr = new ArrayList<>();
        while(temp != null){arr.add(temp.val); temp = temp.next;}
        for(int i =0; i+k<=arr.size(); i=i+k){
            Collections.reverse(arr.subList(i,i+k));
        }
        System.out.println(arr);
        for(int i=0; i<arr.size(); i++){
            ListNode x = new ListNode(arr.get(i));
            answer.next = x;
            answer = x;
        }
        return submit.next;
    }
}