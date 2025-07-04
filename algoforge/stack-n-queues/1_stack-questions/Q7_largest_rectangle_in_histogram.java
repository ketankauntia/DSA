//https://leetcode.com/problems/largest-rectangle-in-histogram/


// next smaller element on the left and right chahiye.. 
// max width will be between left and right.


import java.util.Stack;

// TC: o(n) + O(n) | SC: o(n)

public int largestRectangleArea_BettterSolution(int[] heights) {
    Stack<Integer> st = new Stack<>();
    int maxArea = 0;
    int n = heights.length;

    for(int i=0; i<n; i++){

        // heights[st.peek()]>heights[i] means that this is the element we need to calculate area for.
        // why? coz the next element ( arr[i] ) is smaller, so we have found the next_Smaller_Element.
        // if we have the next smaller element then we need to calculate the area of it as well.
        // and we also need to pop this current element out.
        // what will be the next_Smaller_Element? -> at the index i, coz that is smaller than peek elem.
        while(!st.empty() && heights[st.peek()]>heights[i]){ 
            int currElement = heights[st.peek()];
            st.pop();

            int next_Smaller_Element = i;
            int prev_Smaller_Element = st.isEmpty()? -1 : st.peek();

            int area = currElement * (next_Smaller_Element - prev_Smaller_Element - 1);

            if(area>maxArea){
                maxArea = area;
            }
        }
        st.push(i);
    }

    // but what if there are elements leftover??
    while(!st.isEmpty()){
        int next_Smaller_Element = n;
        int currIndex = st.peek();
        st.pop();

        int prev_Smaller_Element = st.isEmpty()? -1 : st.peek();

        int area = heights[currIndex] * (next_Smaller_Element - prev_Smaller_Element - 1);

        if(area>maxArea){
            maxArea = area;
        }
    }

    return maxArea;
}


// 2 pass: way more extra space and iterations. ( good for understanding though. )
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
