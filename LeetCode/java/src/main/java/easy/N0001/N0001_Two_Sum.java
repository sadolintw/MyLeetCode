package easy.N0001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int num = nums[i];
            int temp = target - num;
            if(indexMap.get(temp)!=null){
                int tempIndex = indexMap.get(temp);
                if(tempIndex != i){
                    return new int[]{tempIndex, i};
                }
            }else{
                indexMap.put(num, i);
            }
        }
        return new int[]{};
    }
}

//////////////////////////////////////////////////////////////////

public class N0001_Two_Sum {


    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString(solution.twoSum(nums, 5)));
    }
}