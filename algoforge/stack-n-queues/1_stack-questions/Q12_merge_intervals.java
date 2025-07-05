// https://leetcode.com/problems/merge-intervals/

import java.util.Arrays;
import java.util.Stack;

public class Q12_merge_intervals {

    public static class Pair implements Comparable<Pair>{
        int st;
        int et;

        Pair(int st, int et){
            this.st = st;
            this.et = et;
        }

        // this > other return +ve
        // this = other return 0
        // this < other return -ve
        public int compareTo(Pair other){
            if(this.st != other.st){
                return this.st - other.st;
            } else{
                return this.et - other.et;
            }
        }
    }

    public int[][] merge(int[][] intervals) {
        // we merge overlapping intervals and print in increasing order.

        // when checking for overlaps, we compare old end time with new start time.
        // final end time is greater of both end times.

        Pair[] p = new Pair[intervals.length];
        for(int i=0;i<intervals.length;i++){
            p[i] = new Pair(intervals[i][0], intervals[i][1]);
        }

        Arrays.sort(p); // sorted based on start time.

        Stack<Pair> st = new Stack<>();

        for(int i=0; i<p.length; i++){

            //  agar pehla wala h, to just push it in.
            if(i==0){ 
                st.push(p[i]);
            } else{ // from 2nd pair onwards. we check first.
                Pair top = st.peek();

                // jo naya wala pair aa ra, uska start time agar
                // prev pair ke end time se zyada h, to simply 
                // push it in, coz we cannot merge it

                // else we merge it. ( end time will be max et)
                if(p[i].st > top.et){
                    st.push(p[i]);
                } else{
                    top.et = Math.max(top.et, p[i].et);
                }
            }
        }

        // Building result [][]
        int[][] res = new int[st.size()][2];
        for (int i = st.size() - 1; i >= 0; i--) {
            Pair pr = st.pop();
            res[i][0] = pr.st;
            res[i][1] = pr.et;
        }

        return res;  
    }
}
