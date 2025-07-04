// https://leetcode.com/problems/basic-calculator-ii/
// (Repetiton of the previous question without parentheses. exact same code.)

import java.util.Stack;

public class Q9_basic_calculator_2 {
    public int calculate(String s) {
       Stack<Integer> st = new Stack<>();
        int num=0;
        char sign = '+';

        for(int i=0 ; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num* 10+(ch - '0');
            }

            if((!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
                if(sign == '+') st.push(num);
                else if (sign == '-') st.push(-num);
                else if (sign == '*') st.push(st.pop() * num);
                else if (sign == '/') st.push(st.pop() / num);

                sign = ch;
                num = 0;
            }
        }

        int res = 0;
        while(!st.isEmpty()){
            res+=st.pop();
        }

        return res;
    }
}
