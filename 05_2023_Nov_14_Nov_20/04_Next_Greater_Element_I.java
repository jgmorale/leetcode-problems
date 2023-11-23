// https://leetcode.com/problems/next-greater-element-i/description/
// Needed to look for the solution
import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] nextgreat = new int[nums2.length];
        // Input: nums1 = [4,1,2], 
        //        nums2 = [1,3,4,2]
        // Output: [-1,3,-1]
        for(int i = nums2.length - 1; i >= 0; i--){
            int num = nums2[i];

            while(!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }

            if (stack.isEmpty()){
                nextgreat[i] = -1;
            } else {
                nextgreat[i] = stack.peek();
            }

            stack.push(num);
        }

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], nextgreat[i]);
        }

        int[] output = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            output[i] = map.get(nums1[i]);
        }

        return output;
    }
}
