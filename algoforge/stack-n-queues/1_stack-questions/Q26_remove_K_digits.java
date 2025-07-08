// https://leetcode.com/problems/remove-k-digits/

import java.util.Stack;
public class Q26_remove_K_digits {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<num.length();i++){
            char val = num.charAt(i);

            // humse badi value rakhi thi to pop krwa diya
            while(k>0 && st.size()>0 && st.peek()>val){
                st.pop();
                k--;
            }
            st.push(val);
        }

        // k se badi value reh gayi, to nikal diya
        while(k-- > 0 && st.size()>0){
            st.pop();
        }
        // kuch nai bacha itna karne ke baad, to empty h..
        if(st.size()==0) return "0";

        // wrna, convert to string
        // but this will make it in reverse order due to stack
        StringBuilder sb = new StringBuilder();
        while(st.size()>0){
            sb.append(st.pop());
        }

        //agar leading zero's hai, to remove them, except the very first one.
        // j>0 means ki, if the string is "0000", we keep atleast one zero for the ans.
        int j =sb.length()-1;
        while(j>0 && sb.charAt(j)=='0'){
            sb.deleteCharAt(j--);
        }

        sb.reverse();
        return sb.toString();
    }
}
