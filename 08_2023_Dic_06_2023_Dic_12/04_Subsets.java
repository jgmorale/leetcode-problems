// https://leetcode.com/problems/subsets/description/

import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // [1,2,3,4,5]
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> input = new ArrayList<Integer>() {{ for (int i : nums) add(i);}};

        int index = 0;
        calSubset(input, res, subset, index);

        return res;
    }

    public static void calSubset(List<Integer> A, List<List<Integer>> res, List<Integer> subset, int index){
        res.add(new ArrayList<>(subset));

        for (int i = index; i < A.size(); i++){
            subset.add(A.get(i));

            calSubset(A, res, subset, i + 1);

            subset.remove(subset.size() - 1);
        }
    }
}
