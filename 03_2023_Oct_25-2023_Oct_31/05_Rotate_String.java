// https://leetcode.com/problems/rotate-string/

class Solution {
    public boolean rotateString(String s, String goal) {
        if (goal.length() != s.length()) return false;

        Character first = goal.charAt(0);
        int n = s.length();
        int start = -1;

        for(int i = 0; i < n; i++){
            if (start != -1 && goal.charAt(i-start) != s.charAt(i)) start = -1;
            if (s.charAt(i) == first && start == -1) start = i;
        }

        for(int i = 0; i < start; i++){
            if(s.charAt(i) != goal.charAt(n-start+i)) return false;
        }

        return start != -1;
    }
}
