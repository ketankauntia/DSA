//  Move Zeroes To End
// Moderate
// Score:
// 160/160
// Average time to solve is 40m
// Asked in companies
// FacebookInfosysMicrosoft
// Problem statement

// Send feedback
// Given an unsorted array of integers, you have to move the array elements in a way such that all the zeroes are transferred to the end, and all the non-zero elements are moved to the front. Use the concept of dynamic memory allocation for taking array input.

// All non zero element will remain in same order as before.

// For example, if the input array is: [0, 1, -2, 3, 4, 0, 5, -27, 9, 0], then the output array must be:

// [1, -2, 3, 4, 5, -27, 9, 0, 0, 0].

// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 2
// 7
// 2 0 4 1 3 0 28
// 5
// 0 0 0 0 1
// Sample Output 1:
// 2 4 1 3 28 0 0
// 1 0 0 0 0
// The explanation for Sample Output 1 :
// In the first testcase, All the zeros are moved towards the end of the array, and the non-zero elements are pushed towards the left, maintaining their order with respect to the original array.

// In the second testcase, All zero are moved towards the end, hence the only non-zero element i.e 1 is in the starting of the array 
// Sample Input 2:
// 2
// 5
// 0 3 0 2 0
// 4
// 0 0 0 0
// Sample Output 2:
// 3 2 0 0 0
// 0 0 0 0

#include<iostream>
using namespace std;
int main()
{
    //write your code here
    int times;
    cin>>times;

    while(times!=0){
        int n;
        cin>>n;
        int* parr= new int[n];

        for(int i=0;i<n;i++){
            // cin>>parr[i];
            cin>>*(parr+i);
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(*(parr+i)!=0){
                cout<<*(parr+i)<<" ";
            }else{
                count++;
            }
        }
        for(int i=0;i<count;i++){
            cout<<0<<" ";
        }
        times--;
        cout<<endl;
    }
}