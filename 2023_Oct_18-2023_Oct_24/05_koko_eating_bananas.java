// https://leetcode.com/problems/koko-eating-bananas/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        // [30,11,23,4,20], h = 5 if h == arr.length -> return max value of the array
        //  [30,11,23,4,20], h = 6 -> [4, 11, 20, 23, 30] -> return 23
        // [3,6,7,11] h=8 -> return 3
        // [3,6,7,11] h=9 -> return 4
        int low = piles[0];
        int high = piles[0];
        for(int i = 0; i < n; i ++){
            if (piles[i] > high) high = piles[i];
            if (piles[i] < low) low = piles[i];
        }
        int ans = high;
        int m = 0;
        while(low <= high){
            m = low + (high-low)/2;
            System.out.println(m);
            boolean p = isPossible(piles, m, h);
            System.out.println(p);
            if (p){
                ans = m;
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        return ans;
    }
    
    public boolean isPossible(int[] piles, int k, int h){
        int i = 0;
        while(i < piles.length){
            if (h == 0) return false;
            if (piles [i] <= k){
                i++;
            } else {
                piles[i] = piles[i] - k;
            }
            h--;
        }
        return true;
    }
}
