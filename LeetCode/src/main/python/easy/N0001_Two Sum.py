class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {}
        for i, num in enumerate(nums):
            print(num)
            
            temp = target - num
            if(temp in dict):
                tempIndex = dict[target - num]
                if(tempIndex != i):
                    return [tempIndex, i]
            else:
                dict[num] = i
        print(dict)
        return []
#=======================================
temp = Solution()
print(temp.twoSum([1,2,3,6],5))
print(temp.twoSum([3,2,4],6))
print(temp.twoSum([3,3],6))