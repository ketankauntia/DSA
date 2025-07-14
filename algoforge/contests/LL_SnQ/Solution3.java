// www.hackerrank.com/contests/algoforge-linkedlist-and-stack/challenges/poisonous-plants


// package algoforge.contests.LL_SnQ;

import java.util.Stack;

class Result {

    /*
     * Complete the 'poisonousPlants' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static int poisonousPlants(List<Integer> p) {
        int maxDays = 0;

        Stack<int[]> st = new Stack<>(); // {element, deathDay}

        for(int i=0; i<p.size(); i++){
            int currEle = p.get(i);
            int deathDay = 0;

            while(st.size()>0 && st.peek()[0] >= currEle){
                deathDay = Math.max(deathDay, st.pop()[1]); // can die after left elements death day
            }

            if(st.size() == 0){
                deathDay = 0; // you can;t die
            } else {
                deathDay++; // will die the next day 
            }

            maxDays = Math.max(maxDays, deathDay);
            st.push(new int[]{currEle, deathDay});
        }

        return maxDays;
    }
}


public class Solution3 {
    
}