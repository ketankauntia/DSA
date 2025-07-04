// https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1
// nearest smaller on left

class Solution {
    public int[] leftSmaller(int[] arr) {
        // code here
        int n = arr.length;
        
        int res[] = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            // if we get a smaller value during iteration,
            // we remove the larger element from the stack.
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }
            
            //adding smallest val from stack to ans array
            res[i] = st.isEmpty() ? -1 : st.peek();
            
            //pushing the element to stack
            st.push(arr[i]);
        }
        return res;
    }
}
