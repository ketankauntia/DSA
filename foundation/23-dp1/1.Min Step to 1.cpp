//  Min Steps to one
// Easy
// Score:
// 80/80
// Average time to solve is 20m
// Problem statement

// Send feedback
// Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:

// 1.) Subtract 1 from it. (n = n - ­1) ,
// 2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
// 3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
// Write brute-force recursive solution for this.

// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 1 <= n <= 200

// Time Limit: 1 sec
// Sample Input 1 :
// 4
// Sample Output 1 :
// 2 
// Explanation of Sample Output 1 :
// For n = 4
// Step 1 :  n = 4 / 2  = 2
// Step 2 : n = 2 / 2  =  1 
// Sample Input 2 :
// 7
// Sample Output 2 :
// 3
// Explanation of Sample Output 2 :
// For n = 7
// Step 1 :  n = 7 ­- 1 = 6
// Step 2 : n = 6  / 3 = 2 
// Step 3 : n = 2 / 2 = 1  

//Memoization

int cMinHelper(int n, int *arr){

    //base case
    if(n<=1) return 0;

    //check if exists
    if(arr[n]!=-1)  return arr[n];

    //else calculate and store
    int x=cMinHelper(n-1, arr);
    int y=INT_MAX, z=INT_MAX;
    if(n%2==0){
        y= cMinHelper(n/2, arr);
    }
    if(n%3==0){
        z=cMinHelper(n/3, arr);
    }

    //return
    return min(x, min(y,z))+1;
}

int countMinStepsToOne(int n)
{
	//Write your code here
    int *arr = new int[n+1];
    for(int i=0;i<=n;i++){
        arr[i]=-1;
    }
    return cMinHelper(n,arr);
}