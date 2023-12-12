// https://leetcode.com/problems/remove-k-digits/
import java.util.*;

// Passed 100% of test cases
class Solution {
    public String removeKdigits(String num, int k) {
        // trivial case
        int n = num.length();
        if (k == n) return "0";
        
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < n; i++) {
            int curr = Character.getNumericValue(num.charAt(i));
            while(k > 0 && !stack.isEmpty() && (stack.peek() > curr || curr == 0 )) {
                if (stack.peek() == 0) break;
                stack.pop();
                k--;
            }
            
            stack.push(curr);
        }

        while(k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        stack = reverseStack(stack);
        StringBuilder output = new StringBuilder();
        boolean leadingZeros = stack.peek() == 0;

        while(!stack.isEmpty()) {
            if (leadingZeros && stack.peek() == 0){
                stack.pop();
                continue;  
            }
            
            leadingZeros = false;
            output.append(stack.pop());
        }
        return output.length() == 0 ? "0" : output.toString();
    }

    public Stack<Integer> reverseStack(Stack<Integer> inStack){
        Stack<Integer> stack = new Stack<Integer>();
        while(!inStack.isEmpty()) stack.push(inStack.pop());
        return stack;
    }
}