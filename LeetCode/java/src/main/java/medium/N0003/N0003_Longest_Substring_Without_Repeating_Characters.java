package medium.N0003;

import java.util.HashMap;
import java.util.Map;

/**
 * Sliding Window Optimized
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int lastIndex = 0 , index = 0 ; index < s.length() ; index++){
            if(map.containsKey(s.charAt(index))){
                lastIndex = Math.max(map.get(s.charAt(index)), lastIndex);
            }
            longestLength = Math.max(longestLength, index - lastIndex + 1);
            map.put(s.charAt(index), index + 1);
        }
        return longestLength;
    }
}

//////////////////////////////////////////////////////////////////

public class N0003_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("aabc"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
    }

}
