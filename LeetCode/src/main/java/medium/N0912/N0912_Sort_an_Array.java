package medium.N0912;

/**
 * merge sort
 */
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }

    private void mergeSort(int[] nums){
        if(nums.length <= 1){
            return;
        }
        int middle = nums.length / 2;
        int leftLength = middle;
        int rightLength = nums.length - leftLength;

        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        for(int i = 0; i < leftLength ; i++){
            leftArray[i] = nums[i];
        }
        for(int i = leftLength; i <nums.length ; i++){
            rightArray[i - leftLength] = nums[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);

        int i = 0;
        int j = 0;

        while(i < leftLength && j < rightLength){
            if(leftArray[i] <= rightArray[j]){
                nums[i + j] = leftArray[i];
                i++;
            }else{
                nums[i + j] = rightArray[j];
                j++;
            }
        }
        while(i < leftLength){
            nums[i + j] = leftArray[i];
            i++;
        }
        while(j < rightLength){
            nums[i + j] = rightArray[j];
            j++;
        }
    }
}

//////////////////////////////////////////////////////////////////

public class N0912_Sort_an_Array {
    public static void main(String[] args) {
        int[] input = {5,1,1,2,0,0};

        Solution solution = new Solution();
        solution.sortArray(input);
        System.out.println(input);
    }
}
