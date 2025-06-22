// https://leetcode.com/problems/valid-parentheses/

public class Q2_Valid_parentheses{
    public boolean isValid(String s) {
        Stack <Character> st = new Stack<>();
        int len = s.length();
        //edge case : if only opening or closing tag is present

        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
        
            if(ch=='(' || ch=='[' || ch=='{'){
                st.push(ch);
            } else{
                if(st.isEmpty()){
                    return false;
                }
                    
                char top = st.pop();

                // Check if it matches the correct opening bracket
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // If stack is empty, all brackets matched
        return st.isEmpty();
    }
}