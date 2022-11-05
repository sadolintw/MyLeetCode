import math
class Solution:
    def isPalindrome(self, x: int) -> bool:
        ref = 0
        sign = '' if x>=0 else '-'
        x = abs(x)
        digits = 1
        if(x > 0):
            digits = int(math.log10(x))+1
        for i in range(int(digits / 2)):
            ref *= 10
            ref += int(x % 10)
            x /= 10
            # print('ref '+str(ref))
        if(digits % 2 == 1):
            x /= 10
        # print((str(ref)+sign) + ' ' + (sign+str(int(x))))
        return (str(ref)+sign)==(sign+str(int(x)))

#=======================================
temp = Solution()
# print(temp.isPalindrome(100))
# print(temp.isPalindrome(-100))
# print(temp.isPalindrome(121))
# print(temp.isPalindrome(-121))
# print(temp.isPalindrome(12345431))
# print(temp.isPalindrome(12345678987654321))
# print(temp.isPalindrome(0.100))
# print(temp.isPalindrome('123'))
print(temp.isPalindrome(0))