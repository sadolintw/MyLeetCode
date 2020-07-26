from typing import List

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        temp = None
        i = 0
        while(i < len(nums)):
            # print('b',nums,'temp',temp)
            if(temp == nums[i]):
                nums.remove(temp)
                i-=1
            temp = nums[i]
            # print('a',nums)
            i+=1
        return len(nums)
#============================================
temp = Solution()
# print(temp.removeDuplicates([1,1,2,3]))
print(temp.removeDuplicates([0,0,1,1,1,2,2,3,3,4]))


