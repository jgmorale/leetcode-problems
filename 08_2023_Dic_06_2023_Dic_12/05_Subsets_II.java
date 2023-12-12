// https://leetcode.com/problems/subsets-ii

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> input = new ArrayList<Integer>() {{ for(int i: nums) add(i); }};
        
        // Calculate subsets
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int index = 0;

        calSubset(input, res, subset, index);

        return res;

    }

    public static void calSubset(List<Integer> A, List<List<Integer>> res, List<Integer> subset, int index){
        res.add(new ArrayList<>(subset));

        for(int i = index; i < A.size(); i++){
            if (i > index && A.get(i) == A.get(i-1)) continue;
            subset.add(A.get(i));

            calSubset(A, res, subset, i + 1);

            subset.remove(subset.size() - 1);
        }
    }
}
