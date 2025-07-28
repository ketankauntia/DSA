// https://leetcode.com/problems/satisfiability-of-equality-equations/description

#include <vector>

class Q6_satisfiability_of_equality_equations {
public:
    vector<int> par;
    vector<int> size;
    int findPar(int u){
        if(par[u] == u) return u;

        return par[u] = findPar(par[u]);
    }

    void merge(int p1, int p2){
        if(size[p1] < size[p2]){
            par[p1] = p2;
            size[p2] += size[p1];
        } else {
            par[p2] = p1;
            size[p1] += size[p2];
        }
    }

    bool equationsPossible(vector<string>& equations) {
        par.resize(26,0);
        size.resize(26,1);

        for(int i=0; i<26; i++){
            par[i] = i;
        }

        for(string &eq: equations){
            if(eq[1] == '!') continue;

            int u = eq[0] - 'a';
            int v = eq[3] - 'a';

            int p1 = findPar(u);
            int p2 = findPar(v);

            if(p1 != p2){ // combining equations with equal sign
                merge(p1,p2);
            }
        }

        for(string &eq: equations){
            if(eq[1] == '=') continue;

            int u = eq[0] - 'a';
            int v = eq[3] - 'a';

            int p1 = findPar(u);
            int p2 = findPar(v);

            if(p1 == p2) return false; // two variables with ! sign should not have same parent
        }

        return true;
    }
};