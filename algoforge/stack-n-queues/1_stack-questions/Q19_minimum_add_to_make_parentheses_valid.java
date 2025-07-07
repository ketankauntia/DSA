// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

public class Q19_minimum_add_to_make_parentheses_valid {
    public int minAddToMakeValid(String s) {
        int extra_closing_brackets = 0;  // extra closing brackets
        int extra_opening_brackets = 0;      // extra opening brackets

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                extra_opening_brackets++;
            } else{ // got a closing backet
                if( extra_opening_brackets==0 ){   // but we do not have any opening backet yet. and are getting only the closing ones.
                    extra_closing_brackets++;
                } else{ // we have recieved opening backets before. so, we subtract it from there..
                    extra_opening_brackets--;
                }
            }
        }
        return extra_closing_brackets+extra_opening_brackets;
    }

    public static void main(String[] args) {
        
    }
}
