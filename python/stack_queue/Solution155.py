# 155. 最小栈

class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        if (not self.min_stack) or self.min_stack[-1] >= val:
            self.min_stack.append(val)
        self.stack.append(val)

    def pop(self) -> None:
        if self.min_stack[-1] == self.stack.pop():
            self.min_stack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        else:
            return None

    def getMin(self) -> int:
        if self.min_stack:
            return self.min_stack[-1]
        else:
            return None
