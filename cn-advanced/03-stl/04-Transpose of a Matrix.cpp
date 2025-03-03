// Transpose of a Matrix
// Score:
// 80/80
// Asked in companies
// OracleZS AssociatesSiemens
// Problem statement

// Send feedback
// You are given a matrix ‘MAT’. Print and return the transpose of the matrix. The transpose of a matrix is obtained by changing rows to columns and columns to rows. In other words, transpose of a matrix A[][] is obtained by changing A[i][j] to A[j][i].

// For example:
// Let matrix be : 
// 1 2
// 3 4

// Then transpose of the matrix will be: 
// 1 3
// 2 4
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 1 <= T <= 10
// 1 <= M, N <= 3*10^3
// 0 <= MAT[i][j] <= 10^7

// Time Limit: 1 sec
// Sample Input 1 :
// 2
// 2 2
// 1 2
// 3 4
// 3 2
// 1 2 
// 2 3
// 3 4
// Sample Output 1 :
// 1 3
// 2 4
// 1 2 3
// 2 3 4
// Explanation For Sample Input 1 :
// For test case 1: 
// The transpose of the matrix will be: 
// 1 3
// 2 4

// For test case 2:    
// The transpose of the matrix will be: 
// 1 2 3
// 2 3 4
// Sample Input 2 :
// 2
// 2 3
// 1 2 3 
// 3 4 5
// 2 1
// 1
// 2
// Sample Output 2 :
// 1 3
// 2 4 
// 3 5
// 1 2

#include <bits/stdc++.h> 
vector<vector<int>> transpose(int m, int n, vector<vector<int>> &mat){
    // Write your code here.

    //creating a new 2d vector array
    vector <vector<int>> ar (n,vector<int>(m));
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            ar[i][j]=mat[j][i];
        }
    }
    return ar;
}