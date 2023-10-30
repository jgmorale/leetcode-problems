// https://leetcode.com/problems/valid-anagram/
import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character,Integer> count = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!count.containsKey(c)) return false;
            if (count.get(c) == 0) return false;
            count.put(c, count.get(c) - 1);
        }

        return true;
    }
}
