// https://leetcode.com/problems/asteroid-collision/

// Passed 100% of test cases
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // input [5,4,3,2,1,-3]
        // output [5,4]

        // input [-10,-9,5,4,3]
        // output [-10,-9,5,4,3] they will never collide

        int n = asteroids.length - 1;
        Stack<Integer> output = new Stack<Integer>();
        for(int i = n; i >= 0; i--){
            if(asteroids[i] < 0){
                output.push(asteroids[i]);
                continue;
            }

            while(!output.isEmpty() && output.peek() < 0 && Math.abs(output.peek()) < asteroids[i]) output.pop();
            if (!output.isEmpty() && output.peek() < 0){
                if (Math.abs(output.peek()) == asteroids[i]) output.pop();        
                continue;
            }

            output.push(asteroids[i]);
        }

        int[] out = new int[output.size()];
        int i = 0;
        while(!output.isEmpty()) out[i++] = output.pop();
        return out;
    }
}
