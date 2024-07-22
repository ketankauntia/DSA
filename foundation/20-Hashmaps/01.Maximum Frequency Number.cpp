// Maximum Frequency Number
// Easy
// Score:
// 80/80
// Average time to solve is 20m
// Problem statement

// Send feedback
// You are given an array of integers that contain numbers in random order. Write a program to find and return the number which occurs the maximum times in the given input.

// If two or more elements are having the maximum frequency, return the element which occurs in the array first.

// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 0 <= N <= 10^8
// Time Limit: 1 sec
// Sample Input 1 :
// 13
// 2 12 2 11 12 2 1 2 2 11 12 2 6 
// Sample Output 1 :
// 2
// Sample Input 2 :
// 6
// 7 2 2 4 8 4
// Sample Output 2 :
// 2
// Explanation:
// Here, both element '2' and element '4' have same frequency but '2' ocurr first in orignal array that's why we are returning '2' as output. 

#include <unordered_map>
int highestFrequency(int arr[], int n) {
    // Write your code here

    unordered_map<int,int> map;
    int maxfreq=0;

    for(int i=0;i<n;i++){
        ++map[arr[i]];
        maxfreq=max(maxfreq, map[arr[i]]);
    }
    int maxfreqrelem;
    for(int i=0;i<n;i++){
        if(map[arr[i]] == maxfreq){
            maxfreqrelem=arr[i];
            break;
        }
    }
    return maxfreqrelem;
}