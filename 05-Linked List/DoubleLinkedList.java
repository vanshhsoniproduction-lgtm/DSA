// Doubly Linked List Node structure
class Node {
    int val;       // Node ka data / value
    Node next;     // Agle node ka reference (pointer)
    Node prev;     // Pichhle node ka reference (pointer)

    // Constructor - jab naya node banega tab value set hogi
    public Node(int val){
        this.val = val;
    }
}

public class DoubleLinkedList {
    Node head;     // Pehla node
    Node tail;     // Aakhri node
    int size = 0;  // Total elements count

    // List ko aage se peeche print karne ke liye display function
    void display(){
        Node temp = head;
        if(head == null){
            System.out.println("NULL");
            return;
        }
        while(temp != null){
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Starting (head) par naya element add karne ke liye
    void addAtHead(int val){
        Node temp = new Node(val);
        if(head == null){
            // Agar list empty hai to head aur tail dono naya node honge
            head = tail = temp;
        } else {
            temp.next = head;   // Naye node ka next purana head banega
            head.prev = temp;   // Purane head ka prev naya node banega
            head = temp;        // Head ko update karke naye node par set kar diya
        }
        size++;
    }

    // Ending (tail) par naya element add karne ke liye
    void addAtTail(int val){
        Node temp = new Node(val);
        if(tail == null){
            // Agar list empty hai to head aur tail dono naya node honge
            head = tail = temp;
        } else {
            tail.next = temp;   // Purane tail ka next naya node hoga
            temp.prev = tail;   // Naye node ka prev purana tail hoga
            tail = temp;        // Tail ko update karke naye node par set kar diya
        }
        size++;
    }

    // Kisi specific index par element insert karne ke liye
    void addAtIndex(int idx, int val){
        // Index valid range [0, size] me hona chahiye
        if(idx < 0 || idx > size){
            System.out.println("Invalid Index");
            return;
        }
        if(idx == 0){
            addAtHead(val);
            return;
        }
        if(idx == size){
            addAtTail(val);
            return;
        }

        Node temp = new Node(val);
        Node cur = head;
        // Target index tak pahuchein
        for(int i = 0; i < idx; i++){
            cur = cur.next;
        }

        // cur wo node hai jiske pehle hume naya node insert karna hai
        Node a = cur.prev; // idx - 1 wala node

        // Pointers reconnect kar rahe hain
        a.next = temp;
        temp.prev = a;
        temp.next = cur;
        cur.prev = temp;

        size++;
    }

    // Head (pehle) node ko delete karne ke liye
    void deleteAtHead(){
        if(head == null){
            System.out.println("Empty");
            return;
        }

        // Agar list me sirf 1 hi element hai
        if(head == tail){
            head = tail = null;
        } else {
            head = head.next;   // Head ko agle node par shift kar diya
            head.prev = null;   // Naye head ka prev null kar diya
        }

        size--;
    }

    // Tail (aakhri) node ko delete karne ke liye
    void deleteAtTail(){
        if(head == null){
            System.out.println("Empty");
            return;
        }

        // Agar list me sirf 1 hi node ho
        if(head == tail){
            head = tail = null;
        } else {
            tail = tail.prev;   // Tail ko ek kadam peeche le aaye
            tail.next = null;   // Naye tail ka next null kar diya
        }
        size--;
    }  

    // Kisi specific index par node delete karne ke liye
    void deleteAtIndex(int idx){ 
        // Index valid range [0, size-1] me hona chahiye delete ke liye
        if(idx < 0 || idx >= size){
            System.out.println("Invalid Index");
            return;
        }
        if(idx == 0){
            deleteAtHead();
            return;
        }
        if(idx == size - 1){
            deleteAtTail();
            return;
        }

        Node cur = head;
        // Jis node ko delete karna hai us tak traverse karein
        for(int i = 0; i < idx; i++){
            cur = cur.next;
        }

        Node a = cur.prev; // Deleted node ka pichhla node
        Node b = cur.next; // Deleted node ka agla node

        // cur node ko bypass kar diya
        a.next = b;
        b.prev = a;

        size--;
    }

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        
        // Elements add kar rahe hain tail par
        dll.addAtTail(10);
        dll.addAtTail(20);
        dll.addAtTail(30);
        dll.addAtTail(40);
        dll.display(); // Output: 10 <-> 20 <-> 30 <-> 40 <-> NULL

        // Index 2 par 999 insert karte hain
        dll.addAtIndex(2, 999);
        dll.display(); // Output: 10 <-> 20 <-> 999 <-> 30 <-> 40 <-> NULL

        // Head par 0 add karte hain
        dll.addAtHead(0);
        dll.display(); // Output: 0 <-> 10 <-> 20 <-> 999 <-> 30 <-> 40 <-> NULL

        // Head delete karte hain
        dll.deleteAtHead();
        dll.display(); // Output: 10 <-> 20 <-> 999 <-> 30 <-> 40 <-> NULL

        // Tail delete karte hain
        dll.deleteAtTail();
        dll.display(); // Output: 10 <-> 20 <-> 999 <-> 30 <-> NULL

        // Index 2 wala element (999) delete karte hain
        dll.deleteAtIndex(2);
        dll.display(); // Output: 10 <-> 20 <-> 30 <-> NULL
    }
}
