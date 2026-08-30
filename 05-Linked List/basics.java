// Basic Node class singly linked list ke liye
// Note: Node class already defined hai package/folder level par, 
// yahan hum Linked List ke basic concepts aur traversal methods samajh rahe hain.

public class basics {
    public static void main(String[] args) {
        // 5 nodes create kar rahe hain: 10 -> 20 -> 30 -> 40 -> 50 
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);

        // Nodes ko aapas me connect kar rahe hain (linking)
        a.next = b; // a ka next b
        b.next = c; // b ka next c
        c.next = d; // c ka next d
        d.next = e; // d ka next e

        // Linked list ko print karte hain
        System.out.print("Linked List: ");
        printLL(a);
        System.out.println();

        // Index 3 par present value fetch karte hain (0-indexed: 40 aana chahiye)
        System.out.println("Value at index 3: " + get(a, 3));
    }

    // Recursive way se kisi index ka element nikalna
    public static int getRecursive(Node head, int idx) {
        if (head == null) return -1; // Index out of bound ya empty list
        if (idx == 0) return head.val;
        return getRecursive(head.next, idx - 1);
    }

    // Iterative way se kisi index ka element nikalna
    public static int get(Node head, int idx) {
        int count = 0;
        Node temp = head;
        while (count < idx && temp != null) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            return -1; // Index list ke size se bada hai
        }
        return temp.val;
    }

    // Linked List ko aage se print karne ke liye (Iterative)
    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    // Linked List ko reverse order me print karne ke liye (Recursive)
    public static void printLLReverse(Node head) {
        if (head == null) return;
        printLLReverse(head.next); // Pehle aage ka print hone do
        System.out.print(head.val + " "); // Phir aate waqt current node print karo
    }
}
