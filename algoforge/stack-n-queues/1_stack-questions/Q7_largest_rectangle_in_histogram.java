//https://leetcode.com/problems/largest-rectangle-in-histogram/


// next smaller element on the left and right chahiye.. 
// max width will be between left and right.


import java.util.Stack;

public class Q7_largest_rectangle_in_histogram {
    
    public int largestRectangleArea(int[] heights) {
        
        int rb[] = new int[heights.length]; // nse index on right
        Stack<Integer> st = new Stack<>();
        st.push(heights.length-1);
        rb[heights.length-1]=heights.length;

        for(int i=heights.length-2;i>=0;i--){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                rb[i]=heights.length;
            } else{
                rb[i]= st.peek();
            }
            st.push(i);
        }

        int lb[] = new int[heights.length]; // nse index on left
        st = new Stack<>();
        st.push(0);
        lb[0]=-1;

        for(int i=1;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                lb[i]=-1;
            } else{
                lb[i]= st.peek();
            }
            st.push(i);
        }

        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int width = rb[i]-lb[i]-1;
            int area = heights[i]*width;
            
            if(area>maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

}
