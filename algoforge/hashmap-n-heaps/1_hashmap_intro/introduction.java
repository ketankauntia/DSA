// package algoforge.hashmap-n-heaps.1_hashmap_intro;

import java.util.HashMap;
public class introduction {
    public static void main(String[] args) {
        
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 100);
        map.put("China", 10);
        map.put("Russia", 50);

        System.out.println(map);

        map.put("USA",365);
        // if(map.containsKey("India"));  // will be used widely
        System.out.println(map.get("India"));
    }
}
