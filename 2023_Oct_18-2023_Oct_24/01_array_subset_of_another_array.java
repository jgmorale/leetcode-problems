import java.util.*;

//https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1?page=1&category[]=Binary%20Search&category[]=Divide%20and%20Conquer&sprint=94ade6723438d94ecf0c00c3937dad55&sortBy=difficulty
class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        if (m > n) return "No";
        Arrays.sort(a1);
        Arrays.sort(a2);
        
        long target = a2[0];
        int start = binarySearch(a1, target);
        if (start == -1) return "No";
    
        int i = 0, j = 0;
        while(i < m && (start + j) < n){
            if(a2[i] != a1[start + j]){
                j++;
            } else {
                i++;
                j++;
            }
        }
        
        return (i == m) ? "Yes": "No";
    }
    
    private int binarySearch(long a[], long target){
        int l = 0, r = a.length, m = -1;
        while(l <= r){
            m = l + (r-l)/2;
            if (a[m] == target){
                return m;
            } else if (a[m] > target){
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return -1;
    }
}
