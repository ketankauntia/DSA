// https://leetcode.com/problems/valid-parenthesis-string/

public class Q22_valid_parenthesis_string {
    public boolean checkValidString(String s) {
        int n = s.length();

        // minimum and maximum no of open parenthesis
        int max =0;
        int min =0;

        for(int i =0;i<n;i++){
            char ch = s.charAt(i);

            if(ch=='('){
                min++;
                max++;
            } else if(ch==')'){
                min--;
                max--;
            } else{
                max++;  // opening bracket, so we increase
                min--;  // closing bracket, so opening ke sath set-off ho gya
            }
            // agar har star ko opening bracket maan ke bhi closing brackets zyada the.. to false h/
            if(max < 0) return false;
            if(min < 0) min=0;  // reset min to 0 since we can't have negative open parentheses count.
            // when we convert * as extra closing bracket, we reset that to star and reset the value.
        }
        // min>0 : opening bracket extra
        // max<0 : closing bracket extra

        return min == 0;
    }
}
