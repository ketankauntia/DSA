//  Kth largest element
// Moderate
// Score:
// 160/160
// Average time to solve is 40m
// Problem statement

// Send feedback
// Given an array 'arr' of random integers and an integer 'k', return the kth largest element in the array.



// Note: Try to do this in O(n*log k) time.


// Example:
// Input:
// 5
// 3 2 5 1 4
// 2
// Output:
// 4
// Explanation:
// Array in non increasing form is [5,4,3,2,1]. So the 2nd largest is 4.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1 :
// 6
// 9 4 8 7 11 3
// 2
// Sample Output 1 :
// 9
// Explanation of sample input 1:
// arr = [9,4,8,7,11,3]
// Array 'arr' in non increasing form is [11,9,8,7,4,3]. So the 2nd largest is 9.
// Sample Input 2 :
// 8
// 2 6 10 11 13 4 1 20
// 4
// Sample Output 2 :
// 10
// Constraints :
// 1 <= n <= 10^5
// 1 <= arr[i] <= 10^5
// 1 <= k <= n
// Time Limit: 1 sec

#include<queue>
int kthLargest(vector<int>&arr, int k) {
    // Write your code here

    //created queue and inserted elements
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i=0;i<k;i++){
        pq.push(arr[i]);
    }

    //now compare the next values to the top.
    //if new element is bigger than top, then remove top and push that..
    //because only larger elements can stay in the queue so that the bottom
    //is occupied by the larger elements
    for(int i=k;i<arr.size();i++){
        if(arr[i]>pq.top()){
            pq.pop();
            pq.push(arr[i]);
        }
    }

    return pq.top();

}