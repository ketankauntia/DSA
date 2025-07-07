// https://leetcode.com/problems/remove-outermost-parentheses/

public class Q20_remove_outermost_parentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        
        int ob = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                // when i get the 1st opening bracket, my opening bracket count will be zero, so i need to ignore that. and just increase the size.
                if(ob != 0){
                    sb.append('(');
                }
                ob++;
            } else{
                // when i get a closing bracket, i need to check if its an outer bracket or not. if it is an outer bracket, which is not required,
                // opening bracket count will be 1, since we increased the ob count from 0 to 1 when we found an opening bracket.
                // so when we find a closing bracket, we set it off by making it to zero..
                if(ob != 1){
                    sb.append(')');
                }
                ob--;
            }
        }
        return sb.toString();
    }
}
