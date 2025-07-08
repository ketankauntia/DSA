// https://leetcode.com/problems/trapping-rain-water/description/

import java.util.Stack;

// method 1 : leftmax & rightmax nikal ke solve for each posi.
public class Q27_trapping_rainwater {
    public int trap(int[] height) {
        
        int n = height.length; 

        int lmax[] = new int[n];    // max from 0 to i-1
        int rmax[] = new int[n];    // max from i+1 to n-1

        // we find the left max height & right max height except the boundary elements
        for(int i=1;i<n;i++){
            lmax[i] = Math.max(lmax[i-1], height[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rmax[i] = Math.max(rmax[i+1], height[i+1]);
        }

        // we calculate total water for each position wrt to minimum of either of the left&right boundry - the level of current position. remaing part can be filled with water.
        // we only calcuate for the middle elements since, ends dont have a left or right boundary respectively.
        int totalwater = 0;
        for(int i=1;i<n-1;i++){
            int maxHeight = Math.min(lmax[i],rmax[i]);
            int currwater = Math.max(maxHeight - height[i],0);
            totalwater+=currwater;
        } 
        return totalwater;
    }
}


// method 2 (copied)

public int trap(int[] height) {
    int n = height.length;

    int[] lmax = new int[n]; // max from 0 to i
    int[] rmax = new int[n]; // max to from i to n-1

    lmax[0] = height[0];
    for(int i=1; i<n; i++){
        lmax[i] = Math.max(lmax[i-1], height[i]);
    }

    rmax[n-1] = height[n-1];
    for(int i=n-2; i>=0; i--){
        rmax[i] = Math.max(rmax[i+1], height[i]);
    }

    int totalWater = 0;

    for(int i=0; i<n; i++){
        int maxHeightAllowed = Math.min(lmax[i], rmax[i]);

        totalWater = totalWater + maxHeightAllowed - height[i];
    }

    return totalWater;
}


// Samrat's approach
// Trapping Rainwater in 1 iteration =========================




// striver's approach : 2 pointer traversing smaller ones first
//

public int trap(int[] height) {
    
    int n=height.length;
    int l=0, r=n-1; // left and right pointer
    int lmax = 0, rmax = 0, totalwater = 0;

    while(l<r){
        if(height[l]<=height[r]){
            // we move right.
            // current height is less, so we need to store water
            if(height[l]<lmax){
                totalwater += lmax-height[l];
            } else{
                // we found a bigger height
                lmax = height[l];
            }
            l++;
        } else{
            // move left.
            if(height[r]<rmax){
                totalwater += rmax-height[r];
            } else{
                // we found a bigger height
                rmax = height[r];
            }
            r--;
        }
    }
    return totalwater;
}

