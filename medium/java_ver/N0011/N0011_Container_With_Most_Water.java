package java_ver.N0011;

class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length -1;
        int maxArea = 0;
        while(left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            while(height[left] >= height[right] && left < right){
                right--;
                maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            }
            while(height[left] < height[right] && left < right){
                left++;
                maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            }
        }

        return maxArea;
    }
}

//////////////////////////////////////////////////////////////////

public class N0011_Container_With_Most_Water {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] height = new int[]{4, 3, 2, 1, 4};
        //int[] height = new int[]{1,1};
        int[] height = new int[]{1,2,1};
        System.out.println(solution.maxArea(height));

    }
}
