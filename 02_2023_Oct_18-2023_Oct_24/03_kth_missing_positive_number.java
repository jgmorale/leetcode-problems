// https://leetcode.com/problems/kth-missing-positive-number/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        // [2,3,4,7,11], k = 5
        // [1,5,6,8,9,10,12,13,...]
        // missingNum =  arr[m] - m + 1
        // 7 -> missingNum = 7 - 4 = 3
        // 11 -> missingNum = 11 - 5 = 6 
        // [4] -> target = 2 -> numMiss = 4 - 1 = 3
        int n = arr.length;
        int last = arr[n-1];
        int numMiss = last - n;
        int i = 0;
        if(numMiss == 0) return n + k;
        if(n == 1){
            return k;
        } else {
            i = binarySearch(arr, k);
        }
        // We are taking the cases on which there are missing numbers in the array
        // [1,2,3,4,10,11,12] -> missing numbers = [5,6,7,8,9] target = 2
        // k = 5 and arr[k] = 11, target = 2 -> arr[k] - k + target;
        numMiss = arr[i] - (i + 1);
        System.out.println(arr[i] + " " + i + " " + k + " " + numMiss);
        if(numMiss == 0) return arr[i] + k;
        if (numMiss == k) return arr[i] - 1;
        if (numMiss < k) return arr[i] + k - numMiss;
        int ans = 0;
        ans = arr[i] + (k - numMiss - 1);
        System.out.println(arr[i] + " " + i + " " + k + " " + numMiss);
        return ans;
    }

    public int binarySearch(int[] arr, int target){
        int l = 0, r = arr.length-1, m = 0, numMiss = 0;
        while (l <= r) {
            m = l + (r-l);
            numMiss = arr[m] - (m + 1);
            if (numMiss == target){
                return m;
            } else if (numMiss < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        };
        return m;
    }
}
