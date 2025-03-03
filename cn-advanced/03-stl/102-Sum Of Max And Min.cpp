// Sum Of Max And Min
// Score:
// 80/80
// Asked in companies
// GoogleSAP LabsMyntra
// Problem statement

// Send feedback
// You are given an array “ARR” of size N. Your task is to find out the sum of maximum and minimum elements in the array.

// Follow Up:
// Can you do the above task in a minimum number of comparisons?
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= T <= 10
// 1 <= N <= 10^5 
// -10^9 <= ARR[i] <= 10^9

// Time limit: 1 second
// Sample Input 1:
// 2
// 7
// 1 2 4 5 6 6 6 
// 6
// -1 -4 5 8 9 3
// Sample Output 1:
// 7
// 5
// Explanation For Sample Input 1:
// For the first test case, the maximum element in the array is 6 and the minimum element in the array is 1.

// For the second test case, the maximum element in the array is 9 and the minimum element in the array is -4.
// Sample Input 2:
// 2
// 5
// 3 3 3 3 3 
// 1
// -1
// Sample Output 2:
// 6
// -2

#include <utility>
#include <algorithm>
#include <climits>


int sumOfMaxMin(vector<int> arr, int n){
	sort(arr.begin(),arr.end());

    int sum=arr[0] + arr[n-1];

    return sum;
}