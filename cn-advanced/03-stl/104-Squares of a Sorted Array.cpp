// Squares of a Sorted Array
// Score:
// 80/80
// Asked in companies
// Natwest GroupAdobeCognizant
// Problem statement

// Send feedback
// You are given an array/list ‘ARR’ of ‘N’ integers. You have to generate an array/list containing squares of each number in ‘ARR’, sorted in increasing order.

// For example :

// Input:
// ‘ARR’ = [-6,-3, 2, 1, 5] 

// If we take a square of each element then the array/list will become [36, 9, 4, 1, 25].
// Then the sorted array/list will be [1, 4, 9, 25, 36].

// Output :
// [1, 4, 9, 25, 36].
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 2
// 4 
// -3 -3 1 2
// 6 
// 0 1 2 3 4 5 
// Sample Output 1:
// 1 4 9 9 
// 0 1 4 9 16 25
// Explanation Of Sample Input 1:
// For test case 1:
// On taking the square of each element ‘ARR’ will become [9, 9, 1, 4].
// Now we can sort the array/list and output will be [1, 4, 9, 9].

// For test case 2:
// On taking the square of each element ‘ARR’ will become [0, 1, 4, 9, 16, 25].
// Now we can see that the array/list is already sorted, so the output will be  [0, 1, 4, 9, 16, 25].
// Sample Input 2:
// 2
// 1
// 5
// 4
// -6 -3 -2 -1
// Sample Output 2:
// 25
// 1 4 9 36
// Explanation Of Sample Input 2:
// For test case 1:
// On taking the square of each element ‘ARR’ will become [25].
// Now as the array/list has only 1 element so it is already sorted, the output will be [25].

// For test case 2:
// On taking the square of each element ‘ARR’ will become [36,9,4,1].
// Now we can see that the array/list is already sorted, so the output will be [36, 9, 4, 1].

#include <bits/stdc++.h> 
vector < int > sqsorted(vector < int > & arr) {
    // Write your code here.
    int size=arr.size();
    vector<int> sq(size);

    for(int i=0;i<size;i++){
        sq[i]=arr[i]*arr[i];
    }

    sort(sq.begin(),sq.end());

    return sq;
}