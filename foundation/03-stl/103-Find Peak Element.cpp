// Find Peak Element
// Score:
// 80/80
// Asked in companies
// GoogleAmazonOla
// Problem statement

// Send feedback
// You are given an array 'arr' of length 'n'. Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.



// Peak element is defined as that element that is greater than both of its neighbors. If 'arr[i]' is the peak element, 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'.



// Assume 'arr[-1]' and 'arr[n]' as negative infinity.



// Note:
// 1.  There are no 2 adjacent elements having same value (as mentioned in the constraints).
// 2.  Do not print anything, just return the index of the peak element (0 - indexed).
// 3. 'True'/'False' will be printed depending on whether your answer is correct or not.


// Example:

// Input: 'arr' = [1, 8, 1, 5, 3]

// Output: 3

// Explanation: There are two possible answers. Both 8 and 5 are peak elements, so the correct answers are their positions, 1 and 3.


// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 5
// 1 8 1 5 3


// Expected Answer:
// 1


// Output on Console:
// True


// Explanation of sample input 1 :
// There are two possible answers. Both 8 and 5 are peak elements, so the correct answers are their positions, 1 and 3. Any of these 2 numbers will print 'True'.


// Sample Input 2:
// 3
// 1 2 1 


// Expected Answer:
// 1


// Output on Console:
// True


// Expected time complexity:
// The expected time complexity is O(log 'n').


// Constraints:
// 1 <= 'n' <= 10^5
// 1 <= 'arr[i]' <= 10^5
// 'arr[i]' != 'arr[i + 1]' for all 'i' in range 0 <= 'i' < 'n' - 1

int findPeakElement(vector<int> &arr) {
    // Write your code here
    int n=arr.size();
     for(int i=1;i<arr.size()-1;i++){
        int a=arr[i-1];
        int b=arr[i+1];
        int curr=arr[i];
        if(curr>a && curr>b){
            return i;
        }
    }

    //edge cases for increasing or decreasing values
    if(arr[0]>arr[1]&&arr[0]>INT_MIN)  {
        return 0;
    }
    if(arr[n-1]>arr[n-2]&&arr[n-1]>INT_MIN){
        return n-1;
    }
    //if there is only 1 value in the array
    if(n==1) return 0;
}