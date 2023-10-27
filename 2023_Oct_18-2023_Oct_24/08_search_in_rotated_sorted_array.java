// https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    public int search(int[] nums, int target) {
        // first search for the position on which the rotated array starts
        // do BinarySearch on both arrays
        int i = binarySearch(nums, target, false);
        return i;
    }

    public int binarySearch(int[] nums, int target, boolean b){
        int l = 0, r = nums.length, m = 0, ans = 0;
        while(l<=r){
            m = l + (r-l)/2;
            boolean c = b ? nums[m] == target : nums[m-1] > nums[m];
            if(c){
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
