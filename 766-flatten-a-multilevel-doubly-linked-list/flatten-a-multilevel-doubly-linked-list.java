class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                Node child = flatten(curr.child);
                Node next = curr.next;

                curr.child = null;
                curr.next = child;
                child.prev = curr;

                Node temp = child;
                while (temp.next != null) {
                    temp = temp.next;
                }

                temp.next = next;
                if (next != null) {
                    next.prev = temp;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}