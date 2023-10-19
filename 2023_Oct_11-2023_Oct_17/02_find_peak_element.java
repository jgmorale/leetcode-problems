
// https://leetcode.com/problems/find-peak-element/
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int l = 0, r = nums.length - 1, m = 0; 
        // [1,2,3,1]

        while(l<=r){
            m = l + (r-l)/2;
            //System.out.println("m:" + m + " l:" + l + " r:" + r);
            if ((m==0 && nums[m]>nums[m+1]) || (m==nums.length-1 && nums[m]>nums[m-1]) ){
                return m;
            } else if (nums[m]>nums[m+1] && nums[m]>nums[m-1]){
                return m;
            } else if (nums[m+1]>nums[m]) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        // [1,2,1,3,5,6,4]
        return m;
    }
}
