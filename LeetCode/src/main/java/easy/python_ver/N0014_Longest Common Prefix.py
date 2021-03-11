class Solution:
    def longestCommonPrefix(self, strs) -> str:
        if(len(strs)==0):
            return ''
        lcp=strs[0]
        l = 0
        for s in strs[1::]:
            # print(s+' '+lcp)
            l=0
            for i in range(len(lcp) if len(lcp) < len(s) else len(s)):
                # print(i)
                if(s[i]==lcp[i]):
                    l+=1
                else:
                    break
            # print('lcp '+lcp+', l '+str(l))
            lcp = lcp[0:l:]
        return lcp

#=======================================
temp = Solution()
print(temp.longestCommonPrefix(['123', '1234', '12345']))
print(temp.longestCommonPrefix(["flower","flow","flight"]))
print(temp.longestCommonPrefix(["abc","def"]))
print(temp.longestCommonPrefix(["abcdefgh","abcdefg","abcdef","abcde"]))
print(temp.longestCommonPrefix([]))