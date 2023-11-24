// https://leetcode.com/problems/next-greater-element-ii/description/

import java.util.*;

// Fails for:
// nums = [5,4,3,2,1] 
// Expected [-1,5,5,5,5]
// Current result [-1,5,4,3,2]
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Input: nums = [1,2,1]
        // Output: [2,-1,2]

        // Input: nums = [1,3,5,7,1,1]
        // Output: [3,5,7,-1,3,3]
        int[] nextgreat = new int[nums.length];

        Stack<Integer> stack = new Stack<Integer>();
        int n = nums.length - 1;
        for(int i = n; i >= 0; i--){
            int num = nums[i];
            while(!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }

            nextgreat[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(num);
        }

        stack = new Stack<Integer>();
        for(int i = 0; i <= n; i++){
            int num = nums[i];
            while(!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }
            if (!stack.isEmpty() && nextgreat[i] == -1) nextgreat[i] = stack.peek();
            stack.push(num);
        }

        HashMap<Integer,Integer> mapping = new HashMap<Integer,Integer>();
        for(int i = 0; i <= n; i++){
            mapping.put(nums[i],nextgreat[i]);
        }

        int[] output = new int[n+1];
        for(int i = 0; i <= n; i++){
            output[i] = mapping.get(nums[i]);
        }

        return output;

    }
}
