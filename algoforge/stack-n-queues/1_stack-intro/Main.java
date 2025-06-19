import java.util.Stack; 
class Main {
    public static void main(String args[]){
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        System.out.println(st.peek());
    }
}
