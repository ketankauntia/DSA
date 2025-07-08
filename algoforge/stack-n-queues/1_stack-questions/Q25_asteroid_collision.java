// https://leetcode.com/problems/asteroid-collision/
import java.util.Stack;
public class Q25_asteroid_collision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        
        // st.push(asteroids[0]);

        for(int i=0; i<n; i++){
            int val = asteroids[i];
            if(val > 0){    // positive value
                st.push(val);
            } else if(val<0){   // negative value
                // [10,2,-5] : smaller value is removed
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(val) ){
                    st.pop();
                }
                // [8,-8] : same value cancels out
                if(!st.isEmpty() && st.peek() == Math.abs(val) ){
                    st.pop();
                    continue;
                }
                if(st.isEmpty() || st.peek()<0){
                    st.push(val);
                }
            }
        }
        Stack<Integer> st1 = new Stack<>();
        while(!st.isEmpty()){
            st1.push(st.pop());
        }
        int ans[] = new int [st1.size()];
        int i=0;
        while(!st1.isEmpty()){
            ans[i++]=st1.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
