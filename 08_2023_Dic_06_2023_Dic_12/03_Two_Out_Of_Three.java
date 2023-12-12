// https://leetcode.com/problems/two-out-of-three/description/

import java.util.*;

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashMap<Integer,Integer> mapping = new HashMap<Integer,Integer>();
        Set<Integer> uniques = new HashSet<Integer>();
        List<Integer> output = new ArrayList<Integer>();

        for(int i = 0; i < nums1.length; i++){
            if(!mapping.containsKey(nums1[i])){
                mapping.put(nums1[i],1);
            }
        }

        for(int i = 0; i < nums2.length; i++){
            if(!mapping.containsKey(nums2[i])){
                mapping.put(nums2[i],1);
                uniques.add(nums2[i]);
            } else if(!uniques.contains(nums2[i])) {
                uniques.add(nums2[i]);
                mapping.put(nums2[i], 2);
                output.add(nums2[i]);
            }
        }

        uniques = new HashSet<Integer>();
        for(int i = 0; i < nums3.length; i++){
            if(!mapping.containsKey(nums3[i])){
                mapping.put(nums3[i],1);
                uniques.add(nums3[i]);
            } else if(!uniques.contains(nums3[i])) {
                int num = mapping.get(nums3[i]);
                uniques.add(nums3[i]);
                if (num == 1){
                    mapping.put(nums3[i], 2);
                    output.add(nums3[i]);
                }
            }
        }

        return output;
    }
}
