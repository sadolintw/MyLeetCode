package medium.N0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length && nums[i] <= 0; ++i){
            if(i == 0 || nums[i - 1] != nums[i]){
                findTwoSumByTwoPointer(res, nums, i, -nums[i]);
            }
        }

        return res;
    }

    static void findTwoSumByTwoPointer(List<List<Integer>> res, int[] numbers, int i, int target){
        int left = i+1;
        int right = numbers.length - 1;
        while( left < right ){
            if(numbers[left] + numbers[right] == target){
                res.add(Arrays.asList(numbers[i], numbers[left++], numbers[right--]));
                //
                while(left < right && numbers[left] == numbers[left-1]){
                    left++;
                }
            }else if(numbers[left] + numbers[right] < target){
                left++;
            }else{
                right--;
            }
        }
    }
}

public class N0015_3Sum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = new int[]{-1,0,1,2,-1,-4};
        //int[] nums = new int[]{0,0,0,0};
        int[] nums = new int[]{-2,0,0,2,2};
        solution.threeSum(nums);
    }
}
