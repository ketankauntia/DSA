// https://leetcode.com/problems/score-of-parentheses/

import java.util.Stack;

// O(1) space solution / without extra space.
public int scoreOfParentheses(String s) {
    int n = s.length();

    int eob = 0;
    int total = 0;
    for(int i=0;i<n;i++){
        char ch = s.charAt(i);

        if(ch == '('){
            eob++;
        } else{
            eob--;
            if (s.charAt(i - 1) == '(') {
                total += 1 << eob;  // 2^depth
            }
            // Why? (s.charAt(i - 1) == '(');
            //That condition confirms you're seeing a primitive "()".
            // If you incremented score on every ')', you would mistakenly count non-primitive pairs like in "((()))" multiple times, leading to overcounting.
        }
    }
    return total;

}



// this is using extra space of a stack.
public class Q23_score_of_parentheses {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch=='('){
                st.push(-1);
            } else{
                if(st.peek() == -1){
                    st.pop();
                    st.push(1);
                } else{
                    int tempVal = 0;
                    while(st.peek() != -1){
                        tempVal += st.pop();
                    }
                    st.pop();
                    st.push(2*tempVal);
                }
            }
        }
        int total = 0;
        while(st.size()>0){
            total+=st.pop();
        }
        return total;
    }

    public static void main(String[] args) {
        
    }
}
