// https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

import java.util.*;
public class Q7_longest_subarray_sum_0 {
    int maxLength(int arr[]) {
        // code here
        
        // we store the sum and index in the hashmap
        // caculate sum and check if its there in map.
        // if there, we cal diff of index to get maxlength
        // if new maxlength greater, we update it
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);     // < sum , index >

        int sum=0;
        int maxLen=0;
        
        for(int i=0;i<arr.length;i++){
            sum += arr[i];

            if(map.containsKey(sum)){
                int currSumIndex = map.get(sum);
                // matlab it is present, we calculate diff index
                int diff = i-currSumIndex;
                maxLen = Math.max(maxLen,diff);
            } else{
                map.put(sum,i);
            }
        }
        return maxLen;
    }
}
