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
import java.util.*;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }   
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<lists.length; i++){
            ListNode temp = lists[i];
            while(temp != null){
                arr.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(arr);
        System.out.println(arr);

        ListNode answer = new ListNode(-1);
        ListNode headNode = answer;
        for(int i=0; i<arr.size(); i++){
            ListNode temp = new ListNode(arr.get(i));
            answer.next = temp;
            answer = temp;
        }
    return headNode.next;
    }
}