//  Modify the array
// Easy
// Score:
// 80/80
// Average time to solve is 20m
// Problem statement

// Send feedback
// Given an array ar of n integers, find the minimum and maximum value in the array and store their addresses in separate pointer variables. Then, modify the values at the addresses pointed by these pointers setting the minimum value to 0 and maximum value to 100.

// Detailed explanation ( Input/output format, Notes, Images )
// Constraints
//  1<= n <=1000
// -10^6  ar[i] <=10^6
// Note
// You don't have to write the entire code. Just complete the definition of modify function listed in the editor.
// Sample Input 1
//  2
// -56 10
// Sample Output 1
// 0 100
// Sample Input 2
// 4
// 1 2 3 4
// Sample Output 2
// 0 2 3 100


void modify(int *ar,int n)
{
	//write your code here
	int *minptr=ar;
	int *maxptr=ar;
	for(int i=1;i<n;i++){
		if(*minptr>*(ar+i)){
			minptr=ar+i;
		}
		if(*maxptr<*(ar+i)){
			maxptr=ar+i;
		}
	}
	*minptr=0;
	*maxptr=100;
}