package java_ver.N0167;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = findPairSumByTwoPointer(numbers, numbers.length, target);
        return result;
    }

    //1-indexed
    static int[] findPairSumByTwoPointer(int[] numbers, int size, int target){
        int l = 0;
        int r = size - 1;

        while( l < r ){
            if(numbers[l] + numbers[r] == target){
                return new int[]{l+1,r+1};
            }else if(numbers[l] + numbers[r] < target){
                l++;
            }else{
                r--;
            }
        }

        return null;
    }
}

public class N0167_Two_Sum_II {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = new int[]{2,7,11,15};
        int target = 9;
        System.out.println( solution.twoSum(numbers, target) );
    }
}
