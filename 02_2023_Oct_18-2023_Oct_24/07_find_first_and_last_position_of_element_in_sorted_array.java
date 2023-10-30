// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        if (nums.length == 0) return ans;
        if (nums.length == 1){
            if (nums[0] == target){
                ans[0] = 0;
                ans[1] = 0;
            }
            return ans;
        }
        int start = binarySearch(nums, target);
        int finish = binarySearch(nums, target + 1);
        if (nums[start] == target) ans[0] = start;
        if (nums[finish-1] == target) ans[1] = finish-1;
        return ans;
    }

    public int binarySearch(int[] nums, int target){
        int l = 0, r = nums.length-1, m = 0;
        while(l <= r){
            m = l + (r-l)/2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target){ 
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (target > nums[m]) return m+1;
        return m;
    }
}
