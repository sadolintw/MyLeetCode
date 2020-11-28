class vo.ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, l1: vo.ListNode, l2: vo.ListNode) -> vo.ListNode:
        values = []
        while(l1):
            values.append(l1.val)
            l1 = l1.next
        while(l2):
            values.append(l2.val)
            l2 = l2.next
        for i in range(len(values)):
            for j in range(i,len(values)):
                if(values[i] > values[j]):
                    temp = values[i]
                    values[i] = values[j]
                    values[j] = temp
        list = None
        first = None
        for i in range(len(values)):
            if(list):
                list.next = vo.ListNode(values[i])
                list = list.next
            else:
                list = vo.ListNode(values[i])
                first = list
        return first

#============================================
# l1 = vo.ListNode(1)
# l2 = vo.ListNode(2)
l1 = vo.ListNode(1, vo.ListNode(2, vo.ListNode(4)))
l2 = vo.ListNode(1, vo.ListNode(3, vo.ListNode(4)))
temp = Solution()
result = temp.mergeTwoLists(l1, l2)
while(result):
    print(result.val)
    result = result.next