// https://leetcode.com/problems/isomorphic-strings/
import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<Character,Character>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if (map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            } else {
                Character c = map.get(s.charAt(i));
                if (c != t.charAt(i)) return false;
            }
        }
        return true;
    }
}
