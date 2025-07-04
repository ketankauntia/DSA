#include <iostream>
#include <vector>
using namespace std;
class Q3_next_larger_element{
    public:
    vector<int> nextLargerElement(vector<int>& arr) {
        // code here
        int n = arr.size();
        stack<int> st;
        vector<int> ngr (n, -1);  //next greatest right
        
        for(int i=n-1;i>=0;i--){
            int curr_ele = arr[i];
            
            while(st.size()>0 && st.top()<=curr_ele){
                st.pop();
            }
            if(st.size()==0){
                ngr[i]=-1;
            } else{
                ngr[i]=st.top();
            }
            st.push(curr_ele);
        }
        return ngr;
    }
};