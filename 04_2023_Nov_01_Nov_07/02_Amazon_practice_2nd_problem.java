/*
 *  String s = '*|**|*|'
 *  startIndexes = [1,1] numOfElementsInsideBoxes in a given range (1,3), (1,5)
 *  endIndexes   = [3,5]
 *  output = [0,2]
 *  because the substring from indeces [1,3] is '|**' which doesnt have a closed box
 *  and the substring from indeces [1,5] is '|**|*' which has 2 elements in the closed box
 * 
 *  String s = '*|***|*|*'
 *  startIndexes = [1,1] '|***|''
 *  endIndexes   = [5,7] '|***|*|'
 *  output = [3,4]
 */

 import java.util.*;

 class Solution1 {
    // Quadratic? solution O(n) + O(m^2 log m??)
    public List<Integer> getElemInBoxes(String s, List<Integer> startIndexes, List<Integer> endIndexes) {
        List<Integer> output = new ArrayList<Integer>();
        List<Integer> compartmentIndexes = new ArrayList<Integer>();
        List<Integer> compartmentSums = new ArrayList<Integer>();
        boolean isOpen = false;
        int counting = 0;

        // '*|**|*|'
        // compartmentIndexes = {1,4,6}
        // compartmentSums = {2,1}
        // startIndexes = [1,1] numOfElementsInsideBoxes in a given range (1,3), (1,5)
        // endIndexes   = [3,5]

        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '|'){
                isOpen = !isOpen;
                compartmentIndexes.add(i);
                if (!isOpen){
                    compartmentSums.add(counting);
                    counting = 0;
                } 
            } else if (s.charAt(i) == '*' && isOpen){
                counting++;
            }
        }

        for(int i = 0; i < startIndexes.size(); i++){
            int start = binarySearch(compartmentIndexes, startIndexes.get(i));
            int end = binarySearch(compartmentIndexes, endIndexes.get(i)); // end = 4 - 1 = 3
            int sum = 0;
            for (int j = start; j < end; j++){
                sum += compartmentSums.get(j+1);
            }
            output.add(sum);
        }

        return output;
    }

    public static int binarySearch(List<Integer> arr, int target){
        int l = 0, r = arr.size()-1, m = 0;
        while(l <= r){
            m = l + (r-l)/2;
            if (arr.get(m) == target){
                return m;
            } else if (arr.get(m) > target){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (target > arr.get(m) && m <arr.size()-1) return m + 1;
        return m;
    }
}

class Solution2 {
    // Quadratic solution?
    public List<Integer> getElemInBoxes(String s, List<Integer> startIndeces, List<Integer> endIndices) {
        List<Integer> output = new ArrayList<Integer>();

        //  String s = '*|**|*|'
        // '|**|*|' '**|*'
        //  [** , **]

        for(int i = 0; i < startIndeces.size(); i++){
            String subStr = s.substring(startIndeces.get(i),endIndices.get(i+1));
            int firstIndex = subStr.indexOf('|');
            int lastIndex = subStr.lastIndexOf('|');
            if (firstIndex >= lastIndex){
                output.add(0);
                continue;
            } 
            subStr = subStr.substring(firstIndex, lastIndex);
            String[] splitAns = subStr.split("|");
            // n = lastIndex - firstIndex + 1
            // totalnum = n - splitAns.length
            output.add(splitAns.length);
        }

        return output;
    }
}