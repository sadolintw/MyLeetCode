class Solution:
    def isValid(self, s: str) -> bool:
      leftDict={
        '(':')',
        '[':']',
        '{':'}'
      }
      isValid=False
      stack = []
      for c in s:
        index = 0 if len(stack)==0 else (len(stack)-1)
        # print(c+' '+str(index)+' '+str(stack))
        if( c in leftDict):
          stack.append(c)
        else:
          if(len(stack) and leftDict[stack[index]]==c):
            stack.pop()
          else:
            return False
      if(len(stack)==0):
        isValid=True
      return isValid
#=======================================
temp = Solution()
print(temp.isValid(''))
print(temp.isValid('[]'))
print(temp.isValid('[](){}'))
print(temp.isValid('[](){'))
print(temp.isValid('[](){(})'))
print(temp.isValid('([)]'))
print(temp.isValid('{[]}'))
print(temp.isValid('{{{{'))
print(temp.isValid('}}}}{{{{'))
