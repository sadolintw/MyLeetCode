package java_ver.N0153;

class Solution {
    public int findMin(int[] nums) {
        if(isSorted(nums[0], nums[nums.length - 1])){
            return nums[0];
        }

        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right){
        if(isSorted(nums[left], nums[right])){
            return nums[left];
        }

        if((right - left + 1) == 2){
            return nums[right];
        }

        return Math.min(findMin(nums, left, left + (right - left)/2),
                        findMin(nums, left + (right - left)/2 + 1, right));
    }

    private boolean isSorted(int left, int right){
        return left <= right?true:false;
    }
}

//////////////////////////////////////////////////////////////////

/**
 * https://zxi.mytechroad.com/blog/leetcode/leetcode-153-find-minimum-in-rotated-sorted-array/
 */
public class N0153_Find_Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        //int[] input = new int[]{3,4,5,1,2};
        //int[] input = new int[]{4,5,6,7,0,1,2};
        //int[] input = new int[]{3,1,2};
        int[] input = new int[]{1};

        Solution solution = new Solution();
        System.out.println(solution.findMin(input));
    }
}
