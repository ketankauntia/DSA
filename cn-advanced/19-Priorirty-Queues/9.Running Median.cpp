//  Running Median
// Hard
// Score:
// 240/240
// Average time to solve is 60m
// Asked in companies
// HikeMyntraSprinklr
// Problem statement

// Send feedback
// You are given a stream of 'N' integers. For every 'i-th' integer added to the running list of integers, print the resulting median.

// Print only the integer part of the median.

// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1 :
// 6
// 6 2 1 3 7 5
// Sample Output 1 :
// 6 4 2 2 3 4
// Explanation of Sample Output 1 :
// S = {6}, median = 6
// S = {6, 2} -> {2, 6}, median = 4
// S = {6, 2, 1} -> {1, 2, 6}, median = 2
// S = {6, 2, 1, 3} -> {1, 2, 3, 6}, median = 2
// S = {6, 2, 1, 3, 7} -> {1, 2, 3, 6, 7}, median = 3
// S = {6, 2, 1, 3, 7, 5} -> {1, 2, 3, 5, 6, 7}, median = 4
// Sample Input 2 :
// 5
// 5 4 3 2 1
// Sample Output 2 :
// 5 4 4 3 3

#include<queue>
void findMedian(int *arr, int n)
{   

    if(n==0)return;

    // Write your code here
    priority_queue<int> s;  //smaller part =max heap(left side)
    priority_queue<int, vector<int>, greater<int>> g; // greater part =min heap(right side)

    s.push(arr[0]);
    cout<<s.top()<<" ";

    for(int i=1;i<n;i++){
        int val = arr[i];

        if(s.size()>g.size()){  //left side has 1 more element than right side

            if(val>s.top()){    //insert value is greater than median : right side me insert
                g.push(val);
            } else{                 //insert value is less than median : shift to right, then insert to left
                g.push(s.top());
                s.pop();
                s.push(val);
            }
            cout<<(s.top() + g.top())/2<<" ";
        } else{ // both sides have equal elements
            if(val<s.top()){     //values less than median then it goes to left
                s.push(val);
            } else{             //value from right will to sent to left then val pushed to right
                g.push(val);
                s.push(g.top());
                g.pop();
            }
            cout<<s.top()<<" ";
        }
    }
}