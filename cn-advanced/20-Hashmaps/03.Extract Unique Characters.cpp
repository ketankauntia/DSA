// Extract Unique characters
// Easy
// Score:
// 80/80
// Average time to solve is 20m
// Problem statement

// Send feedback
// Given a string S, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same, as in the input string.

// Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
// 0 <= Length of S <= 10^8
// Time Limit: 1 sec
// Sample Input 1 :
// ababacd
// Sample Output 1 :
// abcd
// Sample Input 2 :
// abcde
// Sample Output 2 :
// abcde

//-------------------- mycode --------------------

string uniqueChar(string str) {
	// Write your code here
    string s="";
    int arr[26]={0};
    for(int i=0;i<str.length();i++){
        if(arr[str[i]-'a'] == 0){   // if its zero, then it has occured for the 1st time
            s+=str[i];
            arr[str[i]-'a']++;
        } 
    }
    return s;
}

// -------------------------- CN Code ------------------------ 

#include <unordered_set>
string uniqueChar(string str){
    unordered_set<char> charSet;
    string answer;

    for(char ch : str){
        if(charSet.find(ch)==charSet.end()){
            answer.push_back(ch);
            charSet.insert(ch);
        }
    }

    return answer;
}