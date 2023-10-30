// https://leetcode.com/problems/longest-common-prefix
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        String firstStr = strs[0];
        if(firstStr.length() == 0) return "";
        String currPrefix = "";
        boolean shouldBreak = false;

        for(int i = 0; i < firstStr.length(); i++){
            currPrefix = firstStr.substring(0,i+1);
            for(int j = 1; j < strs.length; j++){
                if (currPrefix.length() > strs[j].length()) shouldBreak = true;
                if (strs[j].indexOf(currPrefix) == 0) continue;
                shouldBreak = true;
                break;
            }
            if (shouldBreak) break;
        }

        return currPrefix.length() == 0 ? "": shouldBreak ? currPrefix.substring(0,currPrefix.length() -1) : currPrefix;
    }
}
