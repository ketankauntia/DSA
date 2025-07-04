// https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

import java.util.ArrayList;
import java.util.Stack;

public class Q6_stock_span {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        int[] span = new int[arr.length];
        
        Stack<Integer> st = new Stack<>();
        
        st.push(0);
        span[0]=1;
        
        for(int i=1; i<arr.length;i++){
            
            //algo -> pop karaiye, ans le, push karwaye
            
            //pop kab tak? -> jab tak kuch hai OR 
            //current value is greater than the peek value
            // tab rukenge, jab stack me khud se bada value mil jayega
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            
            //jab rukte h, then we see ki kuch bacha hai ki nai.
            // if we are at zero, matlab, we are at the end, all prev. values were less.
            if(st.size()==0){   // st.isEmpty()
                span[i]=i+1;
            } else{
                span[i]=i-st.peek();
            }
            
            //finally push the val
            st.push(i);
        }
        
        // Convert array to ArrayList as per function signature
        ArrayList<Integer> result = new ArrayList<>();
        for (int val : span) {
            result.add(val);
        }
        return result;
    }
}
