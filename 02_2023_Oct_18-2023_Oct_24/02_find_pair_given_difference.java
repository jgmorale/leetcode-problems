import java.util.*;

// https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1?page=1&category[]=Binary%20Search&category[]=Divide%20and%20Conquer&sprint=94ade6723438d94ecf0c00c3937dad55&sortBy=difficulty
class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        // [2 3 5 5 20 80]
        // {20, 50, 70, 80, 90}
        Arrays.sort(arr);
        
        for(int i = arr.length -1; i >= 0; i--){
            int p1 = arr[i];
            if (p1 < n) return false;
            int p2 = binarySearch(arr, i-1, p1 - n);
            if (p2 != -1) return true;
        }
        return false;
    }
    
    private int binarySearch(int arr[], int start, int target){
        int l = 0, r = start, m = 0;
        while(l <= r){
            m = l + (r-l)/2;
            if (arr[m] == target){
                return m;
            } else if (arr[m] > target){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
