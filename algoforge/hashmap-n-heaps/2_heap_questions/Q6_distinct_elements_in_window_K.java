// https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1

// VERY IMP : ACQUIRE & RELEASE STRATEGY //

// say window size k = 4
// we get k-1 elements in map first.
// now we get another pointer "j" from index 0++;
// index i which now starts from k-1 ke next index se,
// we move one step forward, get the unique count, print/store
// increase j, get that value, remove 1 freq of that from map.

import java.util.*;
import java.util.HashMap;

public class Q6_distinct_elements_in_window_K {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<k-1;i++){
            int oldfreq = map.getOrDefault(arr[i], 0);
            map.put(arr[i],oldfreq+1);
        }
        
        int j =0;
        ArrayList<Integer> ar = new ArrayList<>();

        for(int i=k-1;i<arr.length;i++){
            int oldfreq = map.getOrDefault(arr[i], 0);
            map.put(arr[i],oldfreq+1);
            
            ar.add(map.size());

            int startValFreq = map.get(arr[j]);
            if(startValFreq>1){
                map.put(arr[j], startValFreq-1);
            } else{
                map.remove(arr[j]);
            }
            j++;
        }
        return ar;
    }
}
