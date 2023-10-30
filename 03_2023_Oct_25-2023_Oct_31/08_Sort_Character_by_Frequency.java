// https://leetcode.com/problems/sort-characters-by-frequency/
import java.util.*;

class Solution {
    public String frequencySort(String s) {
        if (s.length() == 1) return s;
        HashMap<Character,String> group = new HashMap<Character, String>();
        for(int i = 0; i < s.length(); i++){
            Character current = s.charAt(i);
            if (!group.containsKey(current)){
                group.put(current, String.valueOf(current));
            } else {
                group.put(current, group.get(current) + current);
            }
        }

        List<String> gr = new ArrayList<String>(group.values());
        gr.sort(new StringLengthComparator());

        String output = "";
        for(int i = 0; i < gr.size(); i++){
            output += gr.get(i);
        }

        return output;
    }

    private class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s2.length() - s1.length();
        }
    }
}
