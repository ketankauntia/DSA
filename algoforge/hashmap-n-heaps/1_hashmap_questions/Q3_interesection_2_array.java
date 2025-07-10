// https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// using set ==========================
// set means storing only the unique keys. no values.

public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set = new HashSet<>();

    for(int e:nums1){
        set.add(e);
    }

    ArrayList<Integer> ans = new ArrayList<>();

    for(int e: nums2){
        if(set.contains(e)){
            ans.add(e);
            set.remove(e);
        }
    }

    int[] res = new int[ans.size()];
    for(int i=0;i<res.length;i++){
        res[i]=ans.get(i);
    }

    return res;
}


//using map ======================
public class Q3_interesection_2_array {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int e: nums1){
            map.put(e,1);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int e:nums2){
            if(map.containsKey(e)){
                ans.add(e);
                map.remove(e);
            }
        }

        // ArrayList to a array for output
        int[] res = new int[ans.size()];
        for(int i=0;i<res.length;i++){
            res[i]=ans.get(i);
        }

        return res;
    }
}
