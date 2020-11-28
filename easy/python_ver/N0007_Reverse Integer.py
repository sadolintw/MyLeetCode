import math
class Solution:
    def reverse(self, x):
        sign = 1
        if(x < 0):
            sign = -1
            x = -x
        val = int(str(x)[::-1])*sign
        if(val in range(-int(math.pow(2,31)), int(math.pow(2,31)-1))):
            return val
        else:
            return 0
#=======================================
temp = Solution()
print(temp.reverse(100))
print(temp.reverse(1002))
print(temp.reverse(-100))
print(temp.reverse(+100))
print(temp.reverse(123456789))
print(temp.reverse(123456789123456789))
print(temp.reverse(-123456789123456789))
print(temp.reverse(-123456789123456789123456789))

