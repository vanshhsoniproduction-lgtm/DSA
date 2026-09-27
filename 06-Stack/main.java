import java.util.Stack;

public class main {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        System.out.println(st);
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.get(0));
    }
}
