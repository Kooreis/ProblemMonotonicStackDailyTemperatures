Here is a C# console application that uses a monotonic stack to solve the daily temperatures problem. The problem is to find out how many days you would have to wait until a warmer temperature for each day.

```C#
using System;
using System.Collections.Generic;

class Program
{
    static void Main(string[] args)
    {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = DailyTemperatures(temperatures);

        foreach (int i in result)
        {
            Console.Write(i + " ");
        }
    }

    public static int[] DailyTemperatures(int[] T)
    {
        int[] res = new int[T.Length];
        Stack<int> stack = new Stack<int>();

        for (int i = T.Length - 1; i >= 0; i--)
        {
            while (stack.Count != 0 && T[i] >= T[stack.Peek()])
            {
                stack.Pop();
            }

            res[i] = stack.Count == 0 ? 0 : stack.Peek() - i;
            stack.Push(i);
        }

        return res;
    }
}
```

This program uses a stack to keep track of the indices of the temperatures. It iterates from the end of the array to the beginning, and for each temperature, it pops the stack until it finds a higher temperature or the stack is empty. The result for the current temperature is the difference between its index and the index of the higher temperature, or 0 if there is no higher temperature.