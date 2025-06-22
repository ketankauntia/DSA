package algoforge.stack-n-queues.1_stack-questions;
import java.util.Stack;
public class Q1_check_parenthesis {

    //duplicate parenthesis
    public static boolean checkParenthesis(String str){
        int n = str.length();
        Stack <Character> st = new Stack<>();

        for(int i=0;i<n;i++){
            char ch = str.charAt(i);

            if( ch == ')' ){
                if(st.peek()=='('){
                    return false;
                }

                while(st.peek()!='('){
                    st.pop();
                }
                st.pop();
            } else{
                st.push(ch);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        
    }
}
