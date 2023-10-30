// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

class Solution {
    public int maxDepth(String s) {
        int currDeep = 0;
        int maxDeep = 0;
        for(int i = 0; i < s.length(); i++){
            Character curr = s.charAt(i);
            if (curr == '(') currDeep++;
            if (curr == ')') currDeep--;
            if (currDeep > maxDeep) maxDeep = currDeep;
        }   
        return maxDeep;
    }
}
