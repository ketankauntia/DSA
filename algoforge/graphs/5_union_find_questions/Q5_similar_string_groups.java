// https://leetcode.com/problems/similar-string-groups/

//  kuch nai samajh aya. copied code and fixed the error.

public class Q5_similar_string_groups {
    public int numSimilarGroups(String[] strs) {
        int[] par;

    public int findPar(int u) {
        return par[u] = par[u] == u ? u : findPar(par[u]);
    }

    public boolean isSimilar(String a, String b) {
        int diff_characters = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff_characters++;
            }
        }

        return diff_characters <= 2;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int total_comps = n;

        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int p1 = findPar(i);

            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    int p2 = findPar(j);

                    if (p1 != p2) {
                        par[p2] = p1;
                        total_comps--;
                    }
                }
            }
        }

        return total_comps;
    }
    }    
}
