//  code not working 

// min stack using 1 stack and 1 constant.
import java.util.Stack;
class MinStack {
    Stack<Long> st; 
    long minval = -1;
    public MinStack() {
        st  = new Stack<>();
    }
    
    public void push(int val) {
        if(st.size()==0){
            st.push((long)val);
            minval = val;
        } else if(val>minval){  // greater values pushed as it is
            st.push((long)val);
        } else{                 // new min val is found
            long updatedValue = 2 * (long)val - minval;
            st.push(updatedValue);  // val+(val-min)
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
            return Math.toIntExact(st.peek());
        }   // val<minval = modified value
            return (int)minval;  
            // we used to get minval, and using this we used to modify the value to make a new smaller val.
            // but the value that we got originally was the new minvalue itself. so we return the minvalue.
        
        
    }
    
    public int getMin() {
        return (int)minval;
    }
}

public class Q16_min_stack_2 {
    public static void main(String[] args) {
        
    }    
}
