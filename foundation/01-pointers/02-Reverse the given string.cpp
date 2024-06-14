// Reverse the String
// Easy
// Score:
// 80/80
// Average time to solve is 20m
// Asked in companies
// Tech MahindraThalesPublicis Sapient
// Problem statement

// Send feedback
// You are given a string 'str' consisting of lower case alphabets. You have to find the reverse of the string.

// For example:
//  If the given string is: str = "abcde". You have to print the string "edcba".
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 ≤ T ≤ 10
// 1 ≤ |str| ≤ 10 ^ 5 

// Where |str| is the length of the string str

// Time limit: 1 sec.
// Sample Input 1:
// 3
// abcde
// coding
// hello1
// Sample Output 1:
// edcba
// gnidoc
// 1olleh
// Explanation of the Sample Input 1:
// For the first test case, STR = "abcde". We need to reverse the string, that is the first element becomes the last element and the last element becomes the first element, the second element becomes the second last element and the second last element becomes the second element and so on. So we get, "edcba".
// Sample Input 2:
// 3
// a
// 1det@Z
// $1xYuP
// Sample Output 2
// a
// Z@ted1
// PuYx1$

#include <cstring>
void func(char *str) 
{
    //write your code here
    int length = strlen(str);
    char *start = str;
    char *end = str + length - 1;

    while (start < end) {
        // Swap the characters pointed to by start and end
        char temp = *start;
        *start = *end;
        *end = temp;

        // Move the pointers towards each other
        start++;
        end--;
    }
}
