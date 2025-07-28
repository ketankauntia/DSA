// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/

// so basically, s1 & s2 ka union find krke smallest char ko parent bana denge
// fir base str me iterate krke check krte hue s1&s2 ka parent de denge for each character.
// agar parent nai h to wo single component h, to we return that to the string ans.

import java.util.*;
public class Q2_lexiographically_smallest_equivanant_string {

    static int[] par;

    public int findPar(int u){
        if(par[u] == u){
            return u;
        }
        return par[u] = findPar(par[u]);
    }

    public void merge(int p1, int p2){
        // merge will depend on the character becomign the parent
        if(p1<p2){
            par[p2] = p1;
        }else{
            par[p1] = p2;
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        par = new int[26];
        for(int i=0; i<26;i++){
            par[i]=i;
        }

        for(int i=0; i<s1.length(); i++){
            int u = s1.charAt(i)-'a';
            int v = s2.charAt(i)-'a';

            int p1 = findPar(u);
            int p2 = findPar(v);

            if(p1!=p2){
                merge(p1,p2);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<baseStr.length(); i++){
            int u = baseStr.charAt(i) - 'a';

            int p = findPar(u);
            sb.append((char)(p+'a'));
        }

        return sb.toString();
    }
}
