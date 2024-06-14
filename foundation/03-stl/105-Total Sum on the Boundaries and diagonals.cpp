// Total Sum on the Boundaries and Diagonals
// Score:
// 80/80
// Problem statement

// Send feedback
// For a given two-dimensional square matrix of size (N x N). Find the total sum of elements on both the diagonals and at all the four boundaries.

// ALTIMAGE

// Note
// You don't have to print anything, just complete the function totalSum and return the answer.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 0 <= N <= 10^3
// 0 <= input[i][j] <10
// Time Limit: 1sec
// Sample input 1:
// 3
// 1 2 3
// 4 5 6
// 7 8 9
// Sample Output 1:
// 45
// Explanation for Sample Output 1:
// The boundary elements are 1, 2, 3, 6, 9, 8, 7 and 4. 

// The first-diagonal elements are 1, 5 and 9. 

// The second-diagonal elements are 3, 5 and 7.

// We just need to add all these numbers making sure that no number is added twice. For example, '1' is both a boundary element and a first-diagonal element similarly, '5' contributes to both the diagonals but they won't be added twice.

// Hence, we add up, [1 + 2 + 3 + 6 + 9 + 8 + 7 + 4 + 5] to give 45 as the output.
// Sample input 2:
// 5
// 1 2 3 4 5
// 6 7 8 9 10
// 11 12 13 14 15
// 16 17 18 19 20
// 21 22 23 24 25
// Sample Output 2:
// 273

int totalSum(vector<vector<int>> input, int n)
{
    int sum=0;
    for(int i=1;i<n-1;i++){
        sum+=input[0][i];
        sum+=input[i][0];
        sum+=input[n-1][i];
        sum+=input[i][n-1];
    }

    for(int i=0,j=0;i<n;i++,j++){
        sum+=input[i][j];
    }
    for(int i=0,j=n-1;i<n;i++,j--){
        sum+=input[i][j];
    }
    if(n%2!=0){
        sum-=input[n/2][n/2];
    }

    return sum;
}

