class Solution:
    def dailyTemperatures(self, T):
        ans = [0] * len(T)
        stack = []