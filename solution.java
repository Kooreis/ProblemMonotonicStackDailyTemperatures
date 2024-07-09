Here is a Java console application that uses a monotonic stack to solve the daily temperatures problem. The problem is to find out how many days you would have to wait until a warmer temperature for each day.

```java
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of days:");
        int n = scanner.nextInt();
        int[] temperatures = new int[n];
        System.out.println("Enter the temperatures:");
        for (int i = 0; i < n; i++) {
            temperatures[i] = scanner.nextInt();
        }
        int[] result = dailyTemperatures(temperatures);
        System.out.println("Days to wait for warmer temperature:");
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}
```

This program first takes the number of days and the temperatures for those days as input. It then uses a monotonic stack to find out how many days you would have to wait until a warmer temperature for each day. The results are then printed to the console.