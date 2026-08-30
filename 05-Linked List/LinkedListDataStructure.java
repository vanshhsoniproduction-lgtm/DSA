// Singly Linked List Implementation
class Linkedlist {
    Node head;     // List ka starting point
    Node tail;     // List ka ending point
    int size = 0;  // List ka total element count

    // Puri Linked List ko print karne ke liye display function
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> "); 
            temp = temp.next;       
        }
        System.out.println("null");
    }

    // List ke end (tail) par element add karne ke liye
    void addAtTail(int val) {
        Node temp = new Node(val);
        if (head == null) {
            // Agar list khali hai to naya node hi head aur tail hoga
            head = tail = temp;
        } else {
            tail.next = temp;   // Current tail ke aage naya node link kiya
            tail = temp;        // Tail pointer ko naye node par set kiya
        }
        size++;
    }

    // List ke start (head) par element add karne ke liye
    void addAtHead(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = tail = temp;
        } else {
            temp.next = head;   // Naye node ke aage purana head lagaya
            head = temp;        // Head pointer ko naye node par set kiya
        }
        size++;
    }

    // Pehle node (head) ko delete karne ke liye
    void deleteAtHead() {
        if (head == null) {
            System.out.println("LL is already empty!");
            return;
        }
        
        if (head == tail) {
            // Agar sirf ek hi node ho list me
            head = tail = null;
        } else {
            head = head.next;   // Head ko agle node par shift kar diya
        }
        size--;
    }

    // Aakhri node (tail) ko delete karne ke liye
    void deleteAtTail() {
        if (head == null) {
            System.out.println("LL is already empty!");
            return;
        }
        
        if (head == tail) {
            // Agar ek hi node tha
            head = tail = null;
        } else {
            // Tail se ek pehle wale node tak traverse karo
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;   // Second last node ka next null kiya
            tail = temp;        // Usi ko ab tail bana diya
        }
        size--;
    }

    // Kisi value ko search karke uska index return karta hai (agar na mile to -1)
    int search(int val) {
        if (head == null) return -1;
        Node temp = head;
        int idx = 0;
        while (temp != null) {
            if (temp.val == val) {
                return idx;     // Value mil gayi to index return karo
            }
            temp = temp.next;
            idx++;
        }
        return -1; // Value poori list me nahi mili
    }   

    // Kisi specific index par element insert karne ke liye
    void insertAtIndex(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid Index");
            return;
        }
        if (idx == 0) {
            addAtHead(val);
            return;
        }
        if (idx == size) {
            addAtTail(val);
            return;
        }

        // Target index se ek pehle wale node (idx-1) tak traverse karein
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        
        Node t = new Node(val);
        t.next = temp.next;     // Naye node ko aage wale node se link kiya
        temp.next = t;          // Pichhle node ko naye node se link kiya
        size++;
    }
}

public class LinkedListDataStructure {
    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        
        // Empty list par delete test
        ll.deleteAtHead();
        System.out.println("Current Size: " + ll.size);

        // Tail par elements add karna
        ll.addAtTail(10);
        ll.addAtTail(20);
        ll.addAtTail(30);
        ll.addAtTail(40);
        System.out.println("Size after additions: " + ll.size);
        
        ll.addAtTail(50);
        ll.display(); // 10 -> 20 -> 30 -> 40 -> 50 -> null

        // Head par element add karna
        ll.addAtHead(0);
        ll.display(); // 0 -> 10 -> 20 -> 30 -> 40 -> 50 -> null
        System.out.println("Size: " + ll.size);

        // Head delete karna
        ll.deleteAtHead();
        ll.display(); // 10 -> 20 -> 30 -> 40 -> 50 -> null
        System.out.println("Size: " + ll.size);

        // Tail delete karna
        ll.deleteAtTail();
        ll.display(); // 10 -> 20 -> 30 -> 40 -> null
        System.out.println("Size: " + ll.size);

        // Search test (value 30 ka index)
        System.out.println("Index of 30: " + ll.search(30));

        // Index 2 par 999 insert karna
        ll.insertAtIndex(2, 999);
        ll.display(); // 10 -> 20 -> 999 -> 30 -> 40 -> null
        System.out.println("Final Size: " + ll.size);
    }    
}
