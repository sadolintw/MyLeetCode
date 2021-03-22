from typing import List
import math
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        temp = None
        length = len(nums)
        if(length == 0):
            return length
        i = 0
        i2 = 0
        while(i < length):
            print(nums,i,i2)
            if(i2 == length):
                break
            if(nums[i] == val):
                temp = nums[i2]
                nums[i2] = nums[i]
                nums[i] = temp
                i2 += 1
                if(i2 >= length):
                    break
                if(nums[i2] == val):
                    i = i2
                    continue
            i += 1
        print(nums,i,i2)
        # nums = nums[i2:j2+1]
        del nums[0:i2]
        print(nums)
        return len(nums)
#============================================
temp = Solution()
# print(temp.removeElement([3,2,2,3], 3))
# print(temp.removeElement([0,1,2,2,3,0,4,2,2], 2))
# print(temp.removeElement([0,1,2,2,3,0,4,2],2))
# print(temp.removeElement([3,3],3))
# print(temp.removeElement([1],1))
# print(temp.removeElement([2,2,3],2))
