
// https://leetcode.com/problems/search-insert-position/description/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1, m = 0;
        // [1,3,5,6] target = 2 m= 1
        // [1,3]

        // Standard output 
        // Try the edge cases
        
        while(l <= r){
            m = l+(r-l)/2;
            //System.out.println("m: " + m + "  l: " + l + "  r: " + r);
            if (nums[m] == target){
                return m;
            } else if (nums[m] > target){
                r = m-1;
            } else {
                l = m+1;
            }
        }
        if (target > nums[m]) return m+1;
        return m;
    }
}
