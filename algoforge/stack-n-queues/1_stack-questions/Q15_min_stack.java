// https://leetcode.com/problems/min-stack/description/

import java.util.Stack;

class MinStack {

    Stack<Integer> st;  // stack
    Stack<Integer> minst; // min stack

    public MinStack() {
        st = new Stack<>();
        minst = new Stack<>();
    }
    
    public void push(int val) {
        if(minst.size()==0 || val <= minst.peek()){
            minst.push(val);
        }
        st.push(val);

    }
    
    public void pop() {
        if(minst.peek().equals(st.peek())){ // V.IMP, int vs INTEGER comparsion was referencing addresses.
            minst.pop();
        }
        st.pop();
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        return st.peek();
    }
    
    public int getMin() {
        if(minst.size()== 0){
            return 0;
        }
        return minst.peek();
    }
}

public class Q15_min_stack {
    public static void main(String[] args) {
        
    }
}
