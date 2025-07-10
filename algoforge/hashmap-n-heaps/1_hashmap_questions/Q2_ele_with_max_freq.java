import java.util.HashMap;
class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int total=0;
        int maxfeq = 0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])==false){
                map.put(nums[i],1);
                maxfeq = Math.max(maxfeq, 1);
            } else{
                int tcount = map.get(nums[i]);
                map.put(nums[i],tcount+1);

                maxfeq = Math.max(maxfeq, tcount+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val = entry.getValue();
            if(val == maxfeq){
                total += val;
            }
        }
        return total;
    }
}

public class Q2_ele_with_max_freq {
    public static void main(String[] args) {
        
    }    
}
