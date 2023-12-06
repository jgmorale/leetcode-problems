// https://leetcode.com/problems/remove-k-digits/
import java.util.*;

class Solution {
    //  num = "1432219", k = 3
        // output = 1219

        //  num = "1435219", k = 2
        // output = 15219 13219

        //  num = "1432219", k = 1
        // output = 132219

        //  num = "1432219", k = 2
        // output = 12219

        //  num = "1402219", k = 1
        // output = 102219

        //  num = "1402219", k = 2
        // output = 02219

        //  num = "1402219", k = 3
        // output = 0219

        // num = "91234", k = 2
        // output = 123

        // // num = "91234", k = 1
        // output = 1234

        // num = "10200", k = 1
        // output = 200

        // num = "10200", k = 2
        // output = 000

        // num = "1432219", k = 1
        // output = 132219

        // num = "1432219", k = 3
        // output = 1219

        // You can take away the digits if there is a 0 involved

    public String removeKdigits(String num, int k) {
        // trivial case
        int n = num.length();
        if (k == n) return "0";
        
        Stack<Integer> stack = new Stack<Integer>();
        // Build monotonic stack with next greater elements from left to right
        for(int i = 0; i < n; i++){
            int curr = Character.getNumericValue(num.charAt(i));
            while(!stack.isEmpty() && stack.peek() < curr) stack.pop();
            stack.push(curr);
        }

        stack = reverseStack(stack);

        Stack<Integer> output = new Stack<Integer>();
        int z = 0;
        for(int i = 0; i<n; i++){
            int curr = Character.getNumericValue(num.charAt(i));

            // if current element is the next greater, remove it from monotonic stack
            if(!stack.isEmpty() && stack.peek() == curr && k > 0){
                stack.pop();
                k--;
                continue;
            }

            // if there is a leading zero, remove previous elements of output stack
            while(!output.isEmpty() && k > 0){
                if (curr != 0) break;
                output.pop();
            }
            output.push(curr);
        }

        output = reverseStack(output);
        StringBuilder out = new StringBuilder();
        while(!output.isEmpty()) out.append(output.pop());

        return Integer.toString(Integer.valueOf(out.toString()));
    }

    public Stack<Integer> reverseStack(Stack<Integer> inStack){
        Stack<Integer> stack = new Stack<Integer>();
        while(!inStack.isEmpty()) stack.push(inStack.pop());
        return stack;
    }
}