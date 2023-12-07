// https://leetcode.com/problems/trapping-rain-water/
import java.util.*;

// Still working on a working solution
class Solution {
    public int trap(int[] height) {
        // [0,1,0,2,1,0,1,3,2,1,2,1]

        int num = height.length;, trappedWater = 0, numElem = 0, min = 0, lastMax = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < num; i++){
            while(!stack.isEmpty() && height[i] > lastMax){
                if (stack.size() == 1) break;
                trappedWater += height[i] - stack.peek();
                numElem++;
                stack.pop();
            }

            if (numElem != 0){
                min = Math.min(height[i], stack.peek());
                lastMax = height[i];
                if (min == stack.peek()) {
                    // Means that we overcalculated the trapped water, so we readjust
                    trappedWater -= min * numElem;
                } else {
                    // Means that we undercalculated the trapped water, so we readjust
                    trappedWater += min * numElem;
                }
                numElem = 0;
                stack.pop();
            }
            
            stack.push(height[i]);
        }

        while(stack.size() > 1){
            // Case when the greater element is on the left 
        }

        return trappedWater;
    }
}