# 2390. 从字符串中移除星号

class Solution:
    def removeStars(self, s: str) -> str:
        stack = []
        for char in s:
            if char != '*':
                stack.append(char)
            else:
                stack.pop()
        return ''.join(stack)

