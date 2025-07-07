// https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/?envType=problem-list-v2&envId=stack

// nai samajh aa ra...

public class Q21_minimum_insertions_to_balance_a_parentheses_string {
    public int minInsertions(String s) {
        
        int n = s.length();
        int extra_opening_brackets = 0;
        int extra_closing_brackets = 0;
        int closing_bracket_req = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(ch=='('){
                extra_closing_brackets++;
            } else{
                // we recived a closing bracket.
                // we'll check if we have 2 closing brackets together on not & move the index if so.
                if(i+1<n && s.charAt(i+1)==')'){
                    i++;
                } else{
                    closing_bracket_req++;
                }

                if(extra_opening_brackets == 0){
                    extra_closing_brackets++;
                } else{
                    extra_opening_brackets--;
                }
            }
        }
        return extra_opening_brackets*2 + extra_closing_brackets + closing_bracket_req;
    }

}
