class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix[0].length-1, k = 0;
        int p = 0, q = matrix.length-1, m = 0;
        
        while(p <= q){
            m = p + (q-p)/2;
            if(matrix[m][0] == target){
                return true;
            } else if (matrix[m][0] > target) {
                q = m - 1; 
            } else {
                p = m + 1;
            }
        }

        while(l <= r){
            k = l + (r-l)/2;
            if(matrix[m][k] == target){
                return true;
            } else if (matrix[m][k] > target) {
                r = k - 1; 
            } else {
                l = k + 1;
            }
        }
        return false;
    }
}
