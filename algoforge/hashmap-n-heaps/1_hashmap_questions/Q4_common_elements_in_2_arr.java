import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Q4_common_elements_in_2_arr {
    public static ArrayList<Integer> commonElements(int a[], int b[]) {
        // Your code here
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int e:a){
            if(freqMap.containsKey(e)==false){
                freqMap.put(e, 1);
            } else{
                int val = freqMap.get(e);
                freqMap.put(e,val+1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int e : b){
            if(freqMap.containsKey(e) && freqMap.get(e)>0){
                ans.add(e);
                int olderfreq = freqMap.get(e);
                freqMap.put(e, olderfreq-1);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
