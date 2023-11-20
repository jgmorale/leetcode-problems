// https://leetcode.com/problems/valid-parentheses/description/

// Solution without stack
// Failing for input "([)]"
class Solution {
    public boolean isValid(String s) {
        int deepA = 0; 
        int deepB = 0;
        int deepC = 0;
        // {[]}
        // deepB = 1 , deepC = 1, 
        for(int i = 0; i < s.length(); i++){

            if (s.charAt(i) == ')'){
                if (deepA == 0 || deepA % 2 != 1) return false;
                deepA--;
            }

            if (s.charAt(i) == '}') {
                if (deepB == 0 || deepB % 2 != 1) return false;
                deepB--;
            }

            if (s.charAt(i) == ']') {
                if (deepC == 0 || deepC % 2 != 1) return false;
                deepC--;
            }

            if (s.charAt(i) == '(') deepA++;
            if (s.charAt(i) == '{') deepB++;
            if (s.charAt(i) == '[') deepC++;
        }
        return true;
    }
}
