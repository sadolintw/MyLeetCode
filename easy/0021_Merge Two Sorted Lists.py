class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
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
                list.next = ListNode(values[i])
                list = list.next
            else:
                list = ListNode(values[i])
                first = list
        return first

#============================================
# l1 = ListNode(1)
# l2 = ListNode(2)
l1 = ListNode(1, ListNode(2, ListNode(4)))
l2 = ListNode(1, ListNode(3, ListNode(4)))
temp = Solution()
result = temp.mergeTwoLists(l1, l2)
while(result):
    print(result.val)
    result = result.next