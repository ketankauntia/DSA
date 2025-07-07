// https://leetcode.com/problems/validate-stack-sequences/

public class Q18_validate_stack_sequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();

        int j=0;
        for(int i=0; i<pushed.length; i++){
            while(st.size()>0 && st.peek() == popped[j]){
                st.pop();
                j++;
            } 
            st.push(pushed[i]);
        }
        
        // aisa bhi ho sakta h ki we pushed everything, and abb loop ended, and we have
        // values that can be popped. so, we check once agian for pops..
        while(st.size()>0 && st.peek() == popped[j]){
            st.pop();
            j++;
        } 

        return j == popped.length;

        // if(st.size()>0){     // why not this?
        //     return false;
        // } else{
        //     return true;
        // }
    }

    public static void main(String[] args) {
        
    }
}
