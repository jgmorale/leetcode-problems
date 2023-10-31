// https://leetcode.com/problems/remove-outermost-parentheses/
class Solution {
    public String removeOuterParentheses(String s) {
        if(s.length() == 1) return s; // trivial case
        int i = 0, j = 0, deep = 0;
        StringBuilder output = new StringBuilder("");
        while(i < s.length()){
            if (s.charAt(i) == '('){
                deep++;
                if(deep == 1) j = i; 
            }
            if (s.charAt(i) == ')') {
                deep--;
                if(deep == 0) output.append(s.substring(j+1,i));
            }
            i++;
        }
        return output.toString();
    }
}
