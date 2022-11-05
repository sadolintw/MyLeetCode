package hard.N0315;

import java.util.*;

/**
 * Time Limit Exceeded
 */
class Solution0 {
    Map<Integer, LinkedList<Integer>> map = new HashMap<>();


    public List<Integer> countSmaller0(int[] nums) {
        int max = 0;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            if(i == nums.length - 1){
                LinkedList<Integer> list= new LinkedList<>();
                list.add(0);
                map.put(nums[i], list);
                max = nums[i];
                continue;
            }
            int result = 0;
            int currentValue = nums[i];
            if(nums[i] > max){
                result = nums.length - (i + 1);
                LinkedList<Integer> list= new LinkedList<>();
                list.add(result);
                map.put(currentValue, list);
                max = currentValue;
            }else{
                result = getResult(nums, currentValue, i);
                if(map.get(currentValue)!=null){
                    map.get(currentValue).add(result);
                }else{
                    LinkedList<Integer> list= new LinkedList<>();
                    list.add(result);
                    map.put(currentValue, list);
                }
            }
        }

        List<Integer> resultList = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){
            resultList.add(map.get(nums[i]).pollLast());
        }

        return resultList;
    }

    private int getResult(int[] nums, int num, int i){
        int j = i + 1;
        if(j > nums.length - 1){
            return map.get(nums[i]).getLast();
        }
        if(num < nums[j]){
            return getResult(nums, num, j);
        }else if(num == nums[j]){
            return map.get(num).getLast();
        }else{
            return getResult(nums, num, j)+1;
        }
    }


}

/**
 * Time Limit Exceeded
 */
class Solution1 {
    public List<Integer> countSmaller1(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i<nums.length; i++) {
            int count =0;
            for(int j =i; j<nums.length; j++){
                if(nums[j]<nums[i]) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }
}

/**
 * https://www.youtube.com/watch?v=2SVLYsq5W8M
 */
class Solution2 {
    private static int lowbit(int x) { return x & (-x); }

    class FenwickTree {
        private int[] sums;

        public FenwickTree(int n) {
            sums = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i < sums.length) {
                sums[i] += delta;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += sums[i];
                i -= lowbit(i);
            }
            return sum;
        }
    };

    public List<Integer> countSmaller(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < sorted.length; ++i)
            if (i == 0 || sorted[i] != sorted[i - 1])
                ranks.put(sorted[i], ++rank);

        FenwickTree tree = new FenwickTree(ranks.size());
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = nums.length - 1; i >= 0; --i) {
            int sum = tree.query(ranks.get(nums[i]) - 1);
            ans.add(tree.query(ranks.get(nums[i]) - 1));
            tree.update(ranks.get(nums[i]), 1);
        }

        Collections.reverse(ans);
        return ans;
    }
}

/**
 * DivideConquer
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/936655/Java-or-DivideConquer
 */
class Solution {
    private class Element {
        int data;
        int idx;

        public Element(int val, int i) {
            data = val;
            idx = i;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] counter = new int[nums.length];
        int n = nums.length;
        Element[] elems = new Element[nums.length];
        for (int i = 0; i < n; i++) {
            elems[i] = new Element(nums[i], i);
        }
        divide(elems, counter, 0, nums.length - 1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < counter.length; i++) {
            ans.add(counter[i]);
        }
        return ans;
    }

    private void divide(Element[] nums, int[] counter, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        divide(nums, counter, start, mid);
        divide(nums, counter, mid + 1, end);
        countAndSort(nums, counter, start, end);
    }

    private void countAndSort(Element[] nums, int[] counter, int start, int end) {
        int lefIdx = start;
        int mid = (start + end) / 2;
        int rightIdx = mid + 1;
        List<Element> tmpList = new ArrayList<>();
        int countOfLowerElems = 0;
        while (lefIdx <= mid && rightIdx <= end) {
            if (nums[lefIdx].data > nums[rightIdx].data) {
                tmpList.add(nums[rightIdx]);
                countOfLowerElems++;
                rightIdx++;
            } else {
                tmpList.add(nums[lefIdx]);
                counter[nums[lefIdx].idx] += countOfLowerElems;
                lefIdx++;
            }
        }
        while (lefIdx <= mid) {
            tmpList.add(nums[lefIdx]);
            counter[nums[lefIdx].idx] += countOfLowerElems;
            lefIdx++;
        }
        while (rightIdx <= end) {
            tmpList.add(nums[rightIdx]);
            rightIdx++;
        }
        Iterator<Element> iter = tmpList.iterator();
        for (int idx = start; idx <= end; idx++) {
            nums[idx] = iter.next();
        }
    }
}

//////////////////////////////////////////////////////////////////

public class N0315_Count_of_Smaller_Numbers_After_Self {
    public static void main(String[] args) {

        Solution solution = new Solution();
//        int[] input = {5,2,6,1};
        int[] input = {5,2,6,1,5,2,6,1};
        solution.countSmaller(input);
    }
}
