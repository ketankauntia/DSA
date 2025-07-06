//  code not working 

// min stack using 1 stack and 1 constant.
import java.util.Stack;
class MinStack {
    Stack<Integer> st; 
    int minval;
    public MinStack() {
        st  = new Stack<>();
        minval = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(st.size()==0){
            st.push(val);
            minval = val;
        } else if(val>minval){  // greater values pushed as it is
            st.push(val);
        } else{                 // new min val is found
            st.push(2 * val - minval);  // val+(val-min)
            minval = val;               // updating min
        }
    }
    
    public void pop() {
        if(st.size()==0){
            return;
        } else{
            if(st.peek() >= minval){
                st.pop();
            } else{     // val < minval
                // calculating the old min, coz new min removed.
                // m = v+v-nv;
                minval = 2* minval-st.pop();
            }
        }
    }
    

    public int top() {
        if(st.size()==0){
            return -1;
        }
        if(st.peek() >= minval){  // val >minval. ok, pop it.
            return st.peek();
        } else{     // val<minval = modified value
            return minval;  
            // we used to get minval, and using this we used to modify the value to make a new smaller val.
            // but the value that we got originally was the new minvalue itself. so we return the minvalue.
        }
        
    }
    
    public int getMin() {
        return minval;
    }
}

public class Q16_min_stack_2 {
    public static void main(String[] args) {
        
    }    
}
