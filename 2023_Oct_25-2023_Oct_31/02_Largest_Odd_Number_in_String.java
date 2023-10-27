// https://leetcode.com/problems/largest-odd-number-in-string/
class Solution {
    public String largestOddNumber(String num) {
        int i = num.length() - 1;
        int endIdx = -1;
        while(i >= 0){
            int val = Character.valueOf(num.charAt(i));
            if (val % 2 == 1){
                endIdx = i;
                break;
            }
            i--;
        }
        return endIdx == -1 ? "" : num.substring(0,endIdx+1);
    }
}
