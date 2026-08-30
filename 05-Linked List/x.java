// LeetCode style ListNode definition
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class x {
    public static void main(String[] args) {
        // Example test:
        // l1 = 2 -> 4 -> 3 (number 342)
        // l2 = 5 -> 6 -> 4 (number 465)
        // Expected sum: 7 -> 0 -> 8 (number 807)
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        
        ListNode result = addTwoNumbers(l1, l2);
        
        System.out.print("Sum List: ");
        printList(result);
    }

    // Do linked lists me stored numbers ko add karne ka function (LeetCode #2: Add Two Numbers)
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy head node banaya jisse list create karna aasan ho jaye
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0; // Addition ka haasil / carry

        // Jab tak dono me se koi ek list bachi ho ya koi carry bacha ho
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Pichhla carry add karo

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Naya carry calculate karo (jaise 14 / 10 = 1)
            // Last digit (sum % 10) ka naya node bana ke attach karo
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummyHead.next; // Dummy node ke aage wala actual head return karo
    }

    // List ko format me print karne ke liye helper method
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
}