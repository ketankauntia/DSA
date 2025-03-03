//  Print Intersection
// Easy
// Score:
// 80/80
// Average time to solve is 20m
// Problem statement

// Send feedback
// You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.

// Note :
// Input arrays/lists can contain duplicate elements.

// The intersection elements printed would be in the order they appear in the second array/list (ARR2).


// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 0 <= N <= 10^6
// 0 <= M <= 10^6

// Time Limit: 1 sec 
// Sample Input 1 :
// 6
// 2 6 8 5 4 3
// 4
// 2 3 4 7 
// Sample Output 1 :
// 2
// 3 
// 4
// Sample Input 2 :
// 4
// 2 6 1 2
// 5
// 1 2 3 4 2
// Sample Output 2 :
// 1 
// 2 
// 2

#include <unordered_map>
void printIntersection(int arr1[], int arr2[], int n, int m) {
  // Write your code here
  unordered_map<int, int> map;

  for(int i=0;i<n;i++){
    ++map[arr1[i]];
  }

  for (int i = 0; i < m; i++) {
    if (map.find(arr2[i]) != map.end()) {
      cout << arr2[i] << "\n";
      if (map[arr2[i]] > 1) {
        --map[arr2[i]];
      } else {
        map.erase(arr2[i]);
      }
    }
  }
}
