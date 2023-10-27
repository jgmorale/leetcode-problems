// https://leetcode.com/problems/reverse-words-in-a-string/
import java.util.*;

class Solution {
    public String reverseWords(String s) {
        Stack<String> words = new Stack<String>();
        String word = "";
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) != ' '){
                word += s.charAt(i);
            } else {
                if (!word.equals("")){
                    words.push(word);
                    word = "";
                }
            }
            i++;
        }
        if(!word.equals("")) words.push(word);
        String output = "";
        while(!words.isEmpty()){
            String next = words.pop();
            output += next;
            if (!words.isEmpty()) output += ' ';
        }

        return output;
    }
}
