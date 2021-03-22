class Solution:
    def romanToInt(self, s: str) -> int:
        sum=0
        values={
            '':0,
            'I':1,
            'V':5,
            'X':10,
            'L':50,
            'C':100,
            'D':500,
            'M':1000
        }
        preCharacter = ''
        for character in s:
            val = values.get(character)
            preVal = values.get(preCharacter)
            # print(str(val)+ ' ' + str(preVal)+ ' ' +str(sum))
            if(val > preVal):
                sum -= 2*preVal
            sum += val
            preCharacter = character
        return sum
#=======================================
temp = Solution()
print(temp.romanToInt('I'))
print(temp.romanToInt('IV'))
print(temp.romanToInt('III'))
print(temp.romanToInt('IX'))
print(temp.romanToInt('LVIII'))
print(temp.romanToInt('MCMXCIV'))
print(temp.romanToInt('MMMCMXCIX'))
print(temp.romanToInt('MMMCDXLIV'))
