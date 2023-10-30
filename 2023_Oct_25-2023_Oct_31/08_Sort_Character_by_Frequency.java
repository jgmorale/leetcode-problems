// https://leetcode.com/problems/sort-characters-by-frequency/
import java.util.*;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i++){
            Character curr = s.charAt(i);
            if(!letterCount.containsKey(curr){
                letterCount.put(curr, 1);
            } else {
                letterCount.put(curr, letterCount.get(curr) + 1);
            }
        }

        

    }
}
