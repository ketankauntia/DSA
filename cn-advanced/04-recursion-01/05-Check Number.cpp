// Check number recursively
// Score:
// 80/80
// Problem statement

// Send feedback
// Given an array of length N and an integer x, you need to find if x is present in the array or not. Return true or false.

// Do this recursively.

// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 1 <= N <= 10^3
// Sample Input 1 :
// 3
// 9 8 10
// 8
// Sample Output 1 :
// true
// Sample Input 2 :
// 3
// 9 8 10
// 2
// Sample Output 2 :
// false

bool checkNumber(int input[], int size, int x) {
  /* Don't write main().
     Don't read input, it is passed as function argument.
     Return output and don't print it.
     Taking input and printing output is handled automatically.
  */
  if(size<0){
    return false;
  }
  if(input[0]==x){
    return true;
  }
  checkNumber(input+1, size-1, x);
  // return false;
}