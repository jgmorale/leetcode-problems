class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int lo = weights[0];
        int hi = 0;
        
        for(int i = 0; i <n ;i++) {
            if (weights[i] > lo) lo = weights[i];
            hi += weights[i];
        }
        int ans = hi;
        int m = -1;
        while(lo <= hi){
            m = lo + (hi-lo)/2;
            if(isPossible(weights, m, days)){
                ans = m;
                hi = m - 1;
            } else {
                lo = m + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] weights, int capacity, int days){
        int curr = 0;
        for(int i = 0; i < weights.length; i++){
            if (curr + weights[i] <= capacity){
                curr += weights[i];
            } else {
                days--;
                if (days == 0) return false;
                curr = weights[i];
            }
        }
        return true;
    }
}
