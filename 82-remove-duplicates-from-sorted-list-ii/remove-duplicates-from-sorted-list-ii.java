class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode answer = new ListNode(-1);
        ListNode x = answer;

        ListNode i = head;
        ListNode j = head;

        while (i != null) {

            // j ko i ki same-value group ke end tak le jao
            while (j != null && i.val == j.val) {
                j = j.next;
            }

            // Agar i ke baad directly j aa gaya,
            // matlab sirf ek occurrence thi
            if (i.next == j) {
                answer.next = i;
                answer = answer.next;
            }

            // Next group start
            i = j;
        }

        answer.next = null;

        return x.next;
    }
}