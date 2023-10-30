// https://leetcode.com/problems/roman-to-integer/
import java.util.*;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> mapping = new HashMap<Character,Integer>();
        mapping.put('I',1);
        mapping.put('V',5);
        mapping.put('X',10);
        mapping.put('L',50);
        mapping.put('C',100);
        mapping.put('D',500);
        mapping.put('M',1000);
        if(s.length() == 1) return mapping.get(s.charAt(0));

        int output = 0;
        for(int i = 0; i < s.length()-1; i++){
            int curr = mapping.get(s.charAt(i));
            int next = mapping.get(s.charAt(i+1));
            if(curr < next){
                output = output + next - curr;
                i++;
            } else {
                output += curr;
            }
            if (i == s.length() - 2) output += mapping.get(s.charAt(i+1));
        }

        return output;
    }
}
