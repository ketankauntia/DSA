// Pair sum to 0
// Moderate
// Score:
// 160/160
// Average time to solve is 40m
// Problem statement

// Send feedback
// Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.



// Note:
// Array A can contain duplicate elements as well.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 0 <= N <= 10^4
// Time Limit: 1 sec
// Sample Input 1:
// 5
// 2 1 -2 2 3
// Sample Output 1:
// 2
// Explanation
// (2,-2) , (-2,2) will result in 0 , so the answer for the above problem is 2.

#include<unordered_map>
int pairSum(int *arr, int n) {
	// Write your code here

    unordered_map<int,int> freq;
    int pairCount = 0;

    for(int i=0;i<n;i++){
        int complement = -arr[i];

        if(freq.find(complement)!=freq.end()){
            pairCount+=freq[complement];
        }

        ++freq [ arr[i] ];
    }
    return pairCount;
}