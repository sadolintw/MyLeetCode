package easy.N0169;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        int times = (int) Math.floor(nums.length/2);
        Map<Integer, Integer> map = new HashMap<>();
        int majority = -1;

        for(int i = 0 ; i < nums.length ; i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        int mostOccuredNum = -1;

        for(int num:map.keySet()){
            mostOccuredNum = mostOccuredNum == -1?num:(map.get(num)>map.get(mostOccuredNum)?num:mostOccuredNum);
        }

        if(map.get(mostOccuredNum) > times){
            majority = mostOccuredNum;
        }

        return majority;
    }
}

//////////////////////////////////////////////////////////////////

public class N0169_Majority_Element {
    public static void main(String[] args) {
        //int[] input = new int[]{2,2,1,1,1,2,2};
        int[] input = new int[]{3,2,3};

        Solution solution = new Solution();

        System.out.println(solution.majorityElement(input));
    }
}
