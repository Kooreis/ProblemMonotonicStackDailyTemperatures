Here is a Python console application that uses a monotonic stack to solve the daily temperatures problem. The problem is to find out how many days you would have to wait until a warmer temperature for each day.

```python
class Solution:
    def dailyTemperatures(self, T):
        ans = [0] * len(T)
        stack = []
        for i in range(len(T) - 1, -1, -1):
            while stack and T[i] >= T[stack[-1]]:
                stack.pop()
            if stack:
                ans[i] = stack[-1] - i
            stack.append(i)
        return ans

def main():
    solution = Solution()
    temperatures = list(map(int, input("Enter temperatures separated by space: ").split()))
    print("Number of days to wait for warmer temperature for each day: ", solution.dailyTemperatures(temperatures))

if __name__ == "__main__":
    main()
```

In this application, you can input the temperatures for each day separated by space. The application will output the number of days you would have to wait until a warmer temperature for each day.