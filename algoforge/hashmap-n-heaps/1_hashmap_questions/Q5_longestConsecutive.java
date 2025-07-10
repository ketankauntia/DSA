import java.util.HashSet;

public class Q5_longestConsecutive {
    public int longestConsecutive(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        int ans = 0;
        for(int e:nums){
            set.add(e);
        }

        for(int currVal:nums){

            if(set.contains(currVal)==false){
                continue;
            }
            int prevVal = currVal - 1;
            int nextVal = currVal + 1;


            // jis sequence me prevValue ana hota, ussme aa gya rehta..
            // bar bar calculate krkre  koi faida nai..
            // say, for 100,101,102 hai.. prev was 102.
            // agar wo longest me hota, to ek bar me hi aa gya rehta.. and agar longest me nai h, to fir gin ke koi faida nai ..
            while(set.contains(prevVal)){
                set.remove(prevVal);
                prevVal--;
            }
            while(set.contains(nextVal)){
                set.remove(nextVal);
                nextVal++;
            }

            ans = Math.max(ans, nextVal - prevVal -1 );

            set.remove(currVal);
        }
        return ans;
    }
}
