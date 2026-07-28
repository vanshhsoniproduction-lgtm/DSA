import java.util.*;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ArrayList<Integer> arr = new ArrayList<>();

        ListNode curr = list1;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        ListNode cur = list2;
        while (cur != null) {
            arr.add(cur.val);
            cur = cur.next;
        }

        Collections.sort(arr);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (int i = 0; i < arr.size(); i++) {
            tail.next = new ListNode(arr.get(i));
            tail = tail.next;
        }

        return dummy.next;
    }
}